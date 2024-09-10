package Commands;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyReader {
    public static List<Character> readFromFile(String filePath) {
        List<Character> characters = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            int symbols;
            while ((symbols = fileReader.read()) != -1) {
                characters.add((char) symbols);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return characters;
    }
}
