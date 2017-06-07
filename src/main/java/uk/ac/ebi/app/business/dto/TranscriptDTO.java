package uk.ac.ebi.app.business.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranscriptDTO {

	private String id;

	private String source;

	private Integer strand;

	private Integer version;

	private String species;

	private Integer end;

	private Integer start;

	private String biotype;

	@JsonProperty("object_type")
	private String objectType;

	@JsonProperty("logic_name")
	private String logicName;

	@JsonProperty("Parent")
	private String parent;

	@JsonProperty("seq_region_name")
	private String seqRegionName;

	@JsonProperty("db_type")
	private String dbType;

	@JsonProperty("is_canonical")
	private Boolean isCanonical;

	@JsonProperty("assembly_name")
	private String assemblyName;

	@JsonProperty("display_name")
	private String displayName;

	@JsonProperty("Translation")
	private TranslationDTO translationDTO;
}
