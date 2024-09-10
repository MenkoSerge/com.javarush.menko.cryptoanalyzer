package Cypher;

import Constansts.Alphabet;
import java.util.ArrayList;
import java.util.List;

public class Encoder {
    public static List<Character> encode(List<Character> source, int key) {
        List<Character> encodedText = new ArrayList<>();
        int alphabetLength = Alphabet.ALPHABET.length;

        for (char symbol : source) {
            boolean isEncoded = false; // Флаг для проверки, найден ли символ в алфавите
            for (int j = 0; j < alphabetLength; j++) {
                if (symbol == Alphabet.ALPHABET[j]) {
                    // Сдвиг вправо на заданный ключ, с учетом циклического сдвига
                    int newIndex = (j + key) % alphabetLength;
                    encodedText.add(Alphabet.ALPHABET[newIndex]);
                    isEncoded = true;
                    break;
                }
            }
            // Если символ не найден в алфавите, добавляем его без изменений
            if (!isEncoded) {
                encodedText.add(symbol);
            }
        }
        return encodedText;
    }
}