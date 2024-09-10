package Cypher;

import Constansts.Alphabet;

import java.util.ArrayList;
import java.util.List;

public class Decoder {

    public static List<Character> decode(List<Character> encodedText, int key) {
        List<Character> decodedText = new ArrayList<>();
        int alphabetLength = Alphabet.ALPHABET.length;

        for (char encodedChar : encodedText) {
            boolean isDecoded = false;
            for (int i = 0; i < alphabetLength; i++) {
                if (encodedChar == Alphabet.ALPHABET[i]) {
                    int newIndex = (i - key) % alphabetLength;
                    if (newIndex < 0) {
                        newIndex += alphabetLength;
                    }
                    decodedText.add(Alphabet.ALPHABET[newIndex]);
                    isDecoded = true;
                    break;
                }
            }
            if (!isDecoded) {
                decodedText.add(encodedChar);
            }
        }
        return decodedText;
    }
}