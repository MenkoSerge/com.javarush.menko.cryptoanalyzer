package Cypher;

import Constansts.Alphabet;

import java.util.ArrayList;
import java.util.List;

public class Decoder {

    public static List<Character> decode(List<Character> encodedText, int key) {
        List<Character> decodedText = new ArrayList<>();
        int alphabetLength = Alphabet.ALPHABET.length;

        // Пробегаемся по каждому символу в зашифрованном тексте
        for (char encodedChar : encodedText) {
            boolean isDecoded = false; // Флаг для проверки, найден ли символ в алфавите
            // Ищем текущий символ в массиве алфавита
            for (int i = 0; i < alphabetLength; i++) {
                if (encodedChar == Alphabet.ALPHABET[i]) {
                    // Вычисляем новый индекс с обратным сдвигом влево
                    int newIndex = (i - key) % alphabetLength;
                    if (newIndex < 0) {
                        newIndex += alphabetLength; // Если индекс отрицательный, циклично смещаем в конец
                    }
                    // Добавляем декодированный символ в список
                    decodedText.add(Alphabet.ALPHABET[newIndex]);
                    isDecoded = true;
                    break;
                }
            }
            // Если символ не найден в алфавите, добавляем его без изменений
            if (!isDecoded) {
                decodedText.add(encodedChar);
            }
        }
        return decodedText;
    }
}