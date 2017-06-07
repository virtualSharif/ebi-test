package uk.ac.ebi.app.business.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneMinDTO {

	private String id;

	@JsonProperty("Transcript")
	private List<TranscriptDTO> transcriptDTOs;

}
