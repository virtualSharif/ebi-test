package uk.ac.ebi.app.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import uk.ac.ebi.app.business.enums.ErrorCodes;

@Data
@AllArgsConstructor
public class StatusDTO {

	private Integer code;

	private String message;

	public StatusDTO(ErrorCodes errorCodes) {
		this.code = errorCodes.getCode();
		this.message = errorCodes.getMessage();
	}
}
