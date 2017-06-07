package uk.ac.ebi.app.rest.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	@ExceptionHandler({ BadRequestException.class })
	public ResponseEntity<Object> handleBadRequest(final BadRequestException ex, final WebRequest request) {
		log.debug("bad request", ex);
		return handleExceptionInternal(ex, ex.getStatusDTO(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ IOException.class })
	public ResponseEntity<Object> handleInternalServerError(final BadRequestException ex, final WebRequest request) {
		log.debug("server error", ex);
		return handleExceptionInternal(ex, ex.getStatusDTO(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}

}
