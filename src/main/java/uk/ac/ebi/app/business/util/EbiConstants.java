package uk.ac.ebi.app.business.util;

public class EbiConstants {

	public static final boolean MULTIPLE_SEQUENCE = true;
	public static final String URL_FOR_SEQUENCE_WITH_TYPE_AND_MULTIPLE_SEQUENCES = "http://rest.ensembl.org/sequence/id/{id}?type={type}&multiple_sequences={multipleSequence}";
	public static final String URL_FOR_LOOKUP_HOMO_SAPIENS_SYMBOL = "http://rest.ensembl.org/lookup/symbol/homo_sapiens/{symbol}?expand=1";
	public static final String REGULAR_EXPRESSION_HGSV = "(\\w+)\\.(\\w+):([a-zA-Z]+)(\\d+)([a-zA-Z]+)";

	private EbiConstants()
    {
        throw new AssertionError();
    }
}
