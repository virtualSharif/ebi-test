package uk.ac.ebi.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import uk.ac.ebi.app.business.dto.TranscriptDTO;
import uk.ac.ebi.app.business.service.TranscriptService;

@Api(tags = "transcript")
@RestController
@RequestMapping(value = "/api/v1/transcripts")
public class TranscriptController {

	@Autowired
	private TranscriptService transcriptService;

	@GetMapping
	public List<TranscriptDTO> find(@RequestParam String symbol, @RequestParam String aminoAcidLetter,
			@RequestParam Integer position) {

		return transcriptService.find(symbol, position, aminoAcidLetter);
	}

	@GetMapping("/hgsv")
	public List<TranscriptDTO> findByHGSV(@RequestParam String hgsvNotation) {

		return transcriptService.findByHGSV(hgsvNotation);
	}
}