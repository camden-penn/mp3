package jenkins.model;
import jenkins.model.IdStrategy;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class IdStrategyRefactorTest {
    @Test
    public void testBlandFilenameParsing()throws Exception{
        final String testFilename = "a_bland_filename.txt";
        IdStrategy idStrategy = new IdStrategy.CaseSensitive();
	final String result = idStrategy.idFromFilename(testFilename);
	assertTrue(testFilename.equals(result));
    }
    @Test
    public void testSpecialCharacterFilenameParsing() throws Exception{
        final String testFilename = "$2234_a_test_of_the_parser.txt";
	IdStrategy idStrategy = new IdStrategy.CaseSensitive();
	final String result = idStrategy.idFromFilename(testFilename);
        final String expectedResult = "∴_a_test_of_the_parser.txt";
	System.out.println();
	assertTrue(expectedResult.equals(result));
    }
}
