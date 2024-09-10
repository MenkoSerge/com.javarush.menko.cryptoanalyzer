package Commands;

import Constansts.Alphabet;
import java.util.ArrayList;
import java.util.List;

public class Encoder {
    public static List<Character> encode(List<Character> source, int key) {
        List<Character> encodedText = new ArrayList<>();
        for (char a : source) {
            for (int j = 0; j < Alphabet.ALPHABET.length; j++) {
                if (a == Alphabet.ALPHABET[j]) {
                    if (j - key < 0) {
                        encodedText.add(Alphabet.ALPHABET[Alphabet.ALPHABET.length - Math.abs(key - j)]);
                    } else {
                        encodedText.add(Alphabet.ALPHABET[j - key]);
                    }
                }
            }
        }
        return encodedText;
    }
}