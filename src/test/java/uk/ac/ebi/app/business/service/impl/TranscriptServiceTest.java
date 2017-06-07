package uk.ac.ebi.app.business.service.impl;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uk.ac.ebi.app.business.dto.StatusDTO;
import uk.ac.ebi.app.business.enums.ErrorCodes;
import uk.ac.ebi.app.business.service.TranscriptService;
import uk.ac.ebi.app.rest.exception.BadRequestException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranscriptServiceTest {

	@Autowired
	private TranscriptService transcriptService;

	private final String blankString = "";
	private final String invalidString = "ebi_test";

	@Test
	public void checkDependencyInjection() {
		assertThat(transcriptService, instanceOf(TranscriptService.class));
	}

	@Test
	public void shouldThrowExceptionWhenInputFieldsAreBlankWhilefind() {
		try {
			transcriptService.find(blankString, 0, blankString);
			fail();
		} catch (BadRequestException e) {
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.REST_EXCEPTION_AT_ENSEMBL));
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputFieldsAreInvalidWhilefind() {
		try {
			int randomPosition = 1202243;
			transcriptService.find(invalidString, randomPosition, invalidString);
			fail();
		} catch (BadRequestException e) {
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.REST_EXCEPTION_AT_ENSEMBL));
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputFieldisBlankWhileFindByHGSV() {
		try {
			transcriptService.findByHGSV(blankString);
			fail();
		} catch (BadRequestException e) {
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.HGSV_PARSING_ERROR));
		}
	}

	@Test
	public void shouldThrowExceptionWhenInputFieldisInvalidWhileFindByHGSV() {
		try {
			transcriptService.findByHGSV(invalidString);
			fail();
		} catch (BadRequestException e) {
			assertEquals(e.getStatusDTO(), new StatusDTO(ErrorCodes.HGSV_PARSING_ERROR));
		}
	}

}