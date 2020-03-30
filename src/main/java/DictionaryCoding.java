import java.util.ArrayList;
import java.util.List;

public class DictionaryCoding {
    private List<String> dictionary;
    private List<Integer> code;
    private String messageToCode;
    private String alphabet;


    public List<Integer> getCode() {
        return code;
    }

    public DictionaryCoding(String messageToCode, String alphabet) {
        dictionary = new ArrayList<>();
        this.messageToCode = messageToCode;
        this.code = new ArrayList<>();
        this.alphabet = alphabet;
    }


    public void encode() {

        fillDictionary(dictionary, alphabet);

        String previousString;
        char currentSymbol;
        char[] message = messageToCode.toCharArray();
        previousString = String.valueOf(message[0]);

        for (int i = 1; i < message.length; i++) {
            currentSymbol = message[i];
            if (dictionary.contains(previousString + currentSymbol)) {
                previousString += currentSymbol;


            } else {
                code.add(findIndex(previousString));
                dictionary.add(previousString + currentSymbol);
                previousString = String.valueOf(currentSymbol);

            }

        }
        code.add(findIndex(previousString));
    }

    public String decode(List<Integer> code) {
        StringBuilder result = new StringBuilder();

        List<String> dictionary = new ArrayList<>();

        fillDictionary(dictionary, alphabet);

        int pk = code.get(0);

        result.append(dictionary.get(pk));
        int k;
        for (int i = 1; i < code.size(); i++) {
            String pc;
            pc = dictionary.get(pk);
            k = code.get(i);

            if (dictionary.size() > k) {
                dictionary.add(pc + dictionary.get(k).toCharArray()[0]);
                result.append(dictionary.get(k));
            } else {
                dictionary.add(pc + pc.toCharArray()[0]);
                result.append(pc).append(pc.toCharArray()[0]);

            }
            pk = k;
        }

        return result.toString();
    }


    private int findIndex(String toSearch) {
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(toSearch)) {
                return i;
            }
        }
        return -1;
    }

    private void fillDictionary(List<String> dictionary, String alphabet) {
        char[] signs = alphabet.toCharArray();
        for (char s : signs) {
            dictionary.add(String.valueOf(s));
        }
    }
}
