import Cypher.Decoder;
import Cypher.Encoder;
import FileManager.MyReader;
import FileManager.MyWritter;


import java.util.List;
import java.util.Scanner;
//

// /Users/nordnexsp.zo.o.nippl9522215738/Desktop/File.txt
// /Users/nordnexsp.zo.o.nippl9522215738/Desktop/result.txt


public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Привет мой друг, расскажи что мы делаем?\n" +
            " 1. Шифруем \n" +
            " 2. Расшифровываем \n" +
            " 3. Ничего, просто закроем программу \n" +
            " ***************************************** \n" +
            " Сделай выбор, выбери 1 или 2 или 3:");

    int userChoice = getUserChoice(console);

    switch (userChoice) {
        case 1:
            encodeFile(console);
            break;
        case 2:
            decodeFile(console);
            break;
        case 3:
            System.out.println("Программа завершена.");
            break;
        default:
            System.out.println("Неправильный  выбор.");
    }
}

private static int getUserChoice(Scanner console) {
    while (!console.hasNextInt()) {
        System.out.println("Пожалуйста, введите 1, 2 или 3:");
        console.next(); // Пропускаем некорректный ввод
    }
    int choice = console.nextInt();
    console.nextLine(); // Поглощаем символ новой строки после ввода числа
    return choice;
}

private static void encodeFile(Scanner console) {
    String inputFile = getValidInput(console, "Пришли мне ссылку на файл в формате С:/folder/file.txt");
    String outputFile = getValidInput(console, "Пришли ссылку куда мы будем сохранять?");
    int key = getIntInputFromUser(console, "Пришли ключ шифрования (целое число):");

    try {
        List<Character> characters = MyReader.readFromFile(inputFile);
        List<Character> encodedCharacters = Encoder.encode(characters, key);
        MyWritter myWritter = new MyWritter();
        myWritter.writer(encodedCharacters, outputFile);

    } catch (Exception e) {
        System.out.println("Ошибка при шифровании: " + e.getMessage());
    }
}

private static void decodeFile(Scanner console) {
    String inputFile = getValidInput(console, "Пришли мне ссылку на файл для дешифровки:");
    String outputFile = getValidInput(console, "Пришли ссылку ссылку на файл в формате С:/folder/result.txt");
    int key = getIntInputFromUser(console, "Пришли ключ для дешифрования (целое число):");

    try {
        List<Character> encodedText = MyReader.readFromFile(inputFile);
        List<Character> decodedText = Decoder.decode(encodedText, key);
        MyWritter myWritter = new MyWritter();
        myWritter.writer(decodedText, outputFile);

    } catch (Exception e) {
        System.out.println("Ошибка при дешифровании: " + e.getMessage());
    }
}

private static String getValidInput(Scanner console, String message) {
    String input;
    do {
        System.out.println(message);
        input = console.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Пусто. Введите правильное значение.");
        }
    } while (input.isEmpty());
    return input;
}

private static int getIntInputFromUser(Scanner console, String message) {
    System.out.println(message);
    while (!console.hasNextInt()) {
        System.out.println("Пожалуйста, введите число:");
        console.next(); // Пропускаем некорректный ввод
    }
    int input = console.nextInt();
    console.nextLine(); // Поглощаем символ новой строки после ввода числа
    return input;
}