import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DictionaryCodingTest {
    private final String message = "abccd_abccd_acd_acd_acd_";
    private DictionaryCoding dictionaryCoding;

    @org.junit.Before
    public void setUp() {
        String alphabet = "abcd_";
        dictionaryCoding = new DictionaryCoding(message, alphabet);
    }

    @Test
    public void shouldCorrectEncodeMessage() {
        Integer[] c = {0, 1, 2, 2, 3, 4, 5, 7, 9, 0, 8, 10, 15, 14, 9};
        List<Integer> expectedCode = new ArrayList<>(Arrays.asList(c));
        dictionaryCoding.encode();

        assertEquals(dictionaryCoding.getCode(), expectedCode);
    }

    @Test
    public void shouldCorrectDecodeMessage() {
        dictionaryCoding.encode();
        String decodedMessage = dictionaryCoding.decode(dictionaryCoding.getCode());
        assertEquals(decodedMessage, message);
    }
}