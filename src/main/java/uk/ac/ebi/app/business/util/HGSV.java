package uk.ac.ebi.app.business.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import uk.ac.ebi.app.business.dto.StatusDTO;
import uk.ac.ebi.app.business.enums.ErrorCodes;
import uk.ac.ebi.app.rest.exception.BadRequestException;

@Data
public class HGSV {

	private static final Logger logger = LoggerFactory.getLogger(HGSV.class);

	private static final String REGULAR_EXPRESSION_HGSV = "(\\w+)\\.(\\w+):([a-zA-Z]+)(\\d+)([a-zA-Z]+)";

	private String symbol;

	private String aminoAcidLetter;

	private Integer position;

	public HGSV(String hgsvNotation) {

		Pattern pattern = Pattern.compile(REGULAR_EXPRESSION_HGSV);
		Matcher matcher = pattern.matcher(hgsvNotation);
		if (matcher.matches()) {
			this.symbol = matcher.group(1);
			this.aminoAcidLetter = matcher.group(3);
			this.position = Integer.parseInt(matcher.group(4));
		} else {
			logger.error(ErrorCodes.HGSV_PARSING_ERROR.getMessage());
			throw new BadRequestException(new StatusDTO(ErrorCodes.HGSV_PARSING_ERROR));
		}
	}

}
