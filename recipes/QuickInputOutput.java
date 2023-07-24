package recipes;
import java.io.*;

// Пример быстрого ввода и вывода
public class QuickInputOutput {
    public static void main(String[] args) {

        // Шаблон
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // Место для кода

        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //

    }
}
