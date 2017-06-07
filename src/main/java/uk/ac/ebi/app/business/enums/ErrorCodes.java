package uk.ac.ebi.app.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ErrorCodes {

	REST_EXCEPTION_AT_ENSEMBL(1001, "Input field is invalid in ENSEMBL web services, please check input fields"),
	HGSV_PARSING_ERROR(1002, "HGSV parsing error, please check the hgsv notation string input");

	@Getter
	private int code;
	@Getter
	private String message;
}
