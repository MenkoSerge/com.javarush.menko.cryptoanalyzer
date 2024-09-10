import Commands.Encoder;
import Commands.MyReader;
import Commands.MyWritter;
import Constansts.Constants;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
//

// /Users/nordnexsp.zo.o.nippl9522215738/Desktop/File.txt
// /Users/nordnexsp.zo.o.nippl9522215738/Desktop/result.txt

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp {
        public static void main(String[] args) {
            // Показываем приветственное сообщение пользователю
            Massage.userMassage();

            // Читаем данные из файла с использованием MyReader
            List<Character> characters = MyReader.readFromFile(Constants.inputFile);

            // Шифруем прочитанные данные с использованием Encoder
            List<Character> encodedCharacters = Encoder.encode(characters, Constants.key);

            // Пишем зашифрованные данные в файл с использованием MyWritter
            MyWritter myWritter = new MyWritter();
            myWritter.writer(encodedCharacters, Constants.outputFile);
        }

}
