package uk.ac.ebi.app.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranslationDTO {

	private String id;

	private String species;

	private Integer end;

	private Integer start;

	private Integer length;

	@JsonProperty("object_type")
	private String objectType;

	@JsonProperty("Parent")
	private String parent;

	@JsonProperty("db_type")
	private String dbType;

}