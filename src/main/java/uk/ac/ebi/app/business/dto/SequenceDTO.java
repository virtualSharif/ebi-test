package uk.ac.ebi.app.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SequenceDTO {

	private String id;

	private String desc;

	private String seq;

	private String molecule;
}
