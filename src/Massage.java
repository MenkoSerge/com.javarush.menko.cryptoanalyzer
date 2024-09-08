import java.util.Scanner;

public class Massage {
    public static void main(String[] userMassage) {
        System.out.println("Привет мой друг, расскажи что мы делаем?\n" +
                " 1. Шифруем \n" +
                " 2. Расшифровываем \n" +
                " 3. Ничего, просто зайкроем программу \n" +
                " ***************************************** \n" +
                " Сделай выбор, выбери 1 или 2 или 3:");

        Scanner console = new Scanner(System.in);
        String userAnswer = console.nextLine();
    }
}
