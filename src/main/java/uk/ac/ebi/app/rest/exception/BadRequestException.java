package uk.ac.ebi.app.rest.exception;

import lombok.Getter;
import lombok.Setter;
import uk.ac.ebi.app.business.dto.StatusDTO;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private StatusDTO statusDTO;

	public BadRequestException(StatusDTO statusDTO) {
		super();
		this.setStatusDTO(statusDTO);
	}

}
