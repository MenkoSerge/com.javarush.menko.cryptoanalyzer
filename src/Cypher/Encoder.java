package Cypher;

import Constansts.Alphabet;
import java.util.ArrayList;
import java.util.List;

public class Encoder {
    public static List<Character> encode(List<Character> source, int key) {
        List<Character> encodedText = new ArrayList<>();
        int alphabetLength = Alphabet.ALPHABET.length;

        for (char symbol : source) {
            boolean isEncoded = false;
            for (int j = 0; j < alphabetLength; j++) {
                if (symbol == Alphabet.ALPHABET[j]) {

                    int newIndex = (j + key) % alphabetLength;
                    encodedText.add(Alphabet.ALPHABET[newIndex]);
                    isEncoded = true;
                    break;
                }
            }

            if (!isEncoded) {
                encodedText.add(symbol);
            }
        }
        return encodedText;
    }
}