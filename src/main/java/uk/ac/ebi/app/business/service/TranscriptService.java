package uk.ac.ebi.app.business.service;

import java.util.List;

import uk.ac.ebi.app.business.dto.TranscriptDTO;

public interface TranscriptService {

	List<TranscriptDTO> find(String symbol, Integer position, String aminoAcidLetter);

	List<TranscriptDTO> findByHGSV(String hgsvNotation);
}
