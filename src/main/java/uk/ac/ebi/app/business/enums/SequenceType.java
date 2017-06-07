package uk.ac.ebi.app.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SequenceType {

	PROTEIN("protein"), GENOMIC("genomic"), CDS("cds"), CDNA("cdna");

	@Getter
	private String value;
}
