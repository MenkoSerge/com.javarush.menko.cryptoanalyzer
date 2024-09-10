import Constansts.Constants;

import java.io.FileReader;
import java.security.PublicKey;
import java.util.Scanner;

public class Massage {
    public static String userMassage() {
        System.out.println("Привет мой друг, расскажи что мы делаем?\n" +
                " 1. Шифруем \n" +
                " 2. Расшифровываем \n" +
                " 3. Ничего, просто зайкроем программу \n" +
                " ***************************************** \n" +
                " Сделай выбор, выбери 1 или 2 или 3:");

        Scanner console = new Scanner(System.in);
        String userAnswer = console.nextLine();


        if (userAnswer.contains("1")){
            System.out.println("Отличный выбор, начинаем шифрование... \n" +
                    "Пришли мне ссылку на файл в формате С:/folder/file.txt");
            Constants.inputFile = console.nextLine();
            System.out.println("А теперь куда мы будем созранять?\n" +
                    "Пришли мне ссылку на файл в формате С:/folder/outputFile.txt");
            Constants.outputFile = console.nextLine();
            System.out.println("А теперь число на основании которого будем шифровать:");
            Constants.key = console.nextInt();
            System.out.println("Данные приняты мы начинаем...");

        } else if (userAnswer.contains("2")){
            System.out.println("Отлично, давай расшифруем...");
        } else if (userAnswer.contains("3")) {
            System.out.println("Классно пообщались, пока пока");

        }
        return userAnswer;
    }


}
