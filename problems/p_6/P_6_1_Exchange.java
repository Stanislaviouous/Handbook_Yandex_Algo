package problems.p_6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class P_6_1_Exchange {

    // Решение задачи A из блока "Размен"
    public static void A(int n) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i <= (Math.ceil(n / 10)); i++) {
            for (int j = 0; j <= (Math.ceil(n / 5)); j++) {
                for (int k = 0; k <= (n); k++) {
                    if (i * 10 + j * 5 + k == n) {
                        arr.add(
                                ((int) (i + j + k) + " 10".repeat(i) + " 5".repeat(j) + " 1".repeat(k))
                        );
                    }
                }
            }
        }
        System.out.println(arr.size());
        for (String str: arr) {
            System.out.println(str);
        }
    }
    //

    // Решение задачи B из блока "Размен"
    public static void solutionFast(int n) {
        long num = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (n > 0){
            if (n >= 50) {
                n -= 50;
                arr.add(50);
            }
            else if (n >= 20) {
                n -= 20;
                arr.add(20);
            }
            else if (n >= 10) {
                n -= 10;
                arr.add(10);
            }
            else if (n >= 5) {
                n -= 5;
                arr.add(5);
            }
            else {
                n -= 1;
                arr.add(1);
            }
            num += 1;
        }
        System.out.println(String.valueOf(num));
        System.out.println(arr.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
    //
}
