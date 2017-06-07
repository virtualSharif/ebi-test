package uk.ac.ebi.app.business.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uk.ac.ebi.app.business.dto.GeneMinDTO;
import uk.ac.ebi.app.business.dto.SequenceDTO;
import uk.ac.ebi.app.business.dto.StatusDTO;
import uk.ac.ebi.app.business.dto.TranscriptDTO;
import uk.ac.ebi.app.business.enums.ErrorCodes;
import uk.ac.ebi.app.business.enums.SequenceType;
import uk.ac.ebi.app.business.service.TranscriptService;
import uk.ac.ebi.app.business.util.EbiConstants;
import uk.ac.ebi.app.business.util.HGSV;
import uk.ac.ebi.app.rest.exception.BadRequestException;

@Service
public class TranscriptServiceImpl implements TranscriptService {

	private static final Logger logger = LoggerFactory.getLogger(HGSV.class);

	@Override
	public List<TranscriptDTO> find(String symbol, Integer position, String aminoAcidLetter) {

		GeneMinDTO geneMinDTO = findGene(symbol);
		List<SequenceDTO> sequenceDTOs = findSequences(geneMinDTO.getId(), SequenceType.PROTEIN,
				EbiConstants.MULTIPLE_SEQUENCE);
		List<String> filteredSequenceIds = filterSequences(sequenceDTOs, position, aminoAcidLetter);
		List<TranscriptDTO> transcriptDTOs = filterTranscripts(geneMinDTO.getTranscriptDTOs(), filteredSequenceIds);
		return transcriptDTOs;
	}

	@Override
	public List<TranscriptDTO> findByHGSV(String hgsvNotation) {

		HGSV hGSV = new HGSV(hgsvNotation);
		return find(hGSV.getSymbol(), hGSV.getPosition(), hGSV.getAminoAcidLetter());
	}

	private List<TranscriptDTO> filterTranscripts(List<TranscriptDTO> transcriptDTOs, List<String> sequenceIds) {

		return transcriptDTOs.stream()
				.filter(p -> p.getTranslationDTO() != null && sequenceIds.contains(p.getTranslationDTO().getId()))
				.collect(Collectors.toList());
	}

	private List<String> filterSequences(List<SequenceDTO> sequenceDTOs, Integer position, String aminoAcidLetter) {

		return sequenceDTOs.stream()
				.filter(p -> isPositionExists(position, p) && isCharMatching(aminoAcidLetter, position, p))
				.map(SequenceDTO::getId).collect(Collectors.toList());
	}

	private List<SequenceDTO> findSequences(String id, SequenceType sequenceType, Boolean multipleSequence) {

		try {
			RestTemplate restTemplate = new RestTemplate();
			SequenceDTO[] sequenceDTOs = restTemplate.getForObject(
					EbiConstants.URL_FOR_SEQUENCE_WITH_TYPE_AND_MULTIPLE_SEQUENCES, SequenceDTO[].class, id,
					sequenceType.getValue(), multipleSequence);
			return Arrays.asList(sequenceDTOs);
		} catch (RuntimeException re) {
			logger.error(re.getMessage());
			throw new BadRequestException(new StatusDTO(ErrorCodes.REST_EXCEPTION_AT_ENSEMBL));
		}

	}

	private GeneMinDTO findGene(String symbol) {

		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForObject(EbiConstants.URL_FOR_LOOKUP_HOMO_SAPIENS_SYMBOL, GeneMinDTO.class, symbol);
		} catch (RuntimeException re) {
			logger.error(re.getMessage());
			throw new BadRequestException(new StatusDTO(ErrorCodes.REST_EXCEPTION_AT_ENSEMBL));
		}
	}

	private boolean isCharMatching(String aminoAcidLetter, Integer position, SequenceDTO sequenceDTO) {

		return aminoAcidLetter.indexOf(sequenceDTO.getSeq().charAt(position - 1)) >= 0;
	}

	private boolean isPositionExists(Integer position, SequenceDTO p) {

		return p.getSeq().length() >= position;
	}

}
