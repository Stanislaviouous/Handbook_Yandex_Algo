package problems.p_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P_4_2_SumOfTwoNumbers {
    // Решение задачи B из блока "Задача «сумма двух чисел»"
    public static void B(String[] args) {
        Scanner str = new Scanner(System.in);
        int a = Integer.parseInt(str.nextLine());
        int[] arrayA = Arrays.stream(str.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int b = Integer.parseInt(str.nextLine());
        int[] arrayB = Arrays.stream(str.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        int[] arrayC;
        if (a < b) {
            for (int i = arrayA.length - 1; i >= 0 ; i--) {
                arrayB[i + (b-a)] += arrayA[i];
            }
            while (arrayB[count] == 0) {

                count++;
            }
            arrayC = arrayB;
        }
        else {
            for (int i = arrayB.length - 1; i >= 0 ; i--) {
                arrayA[i + (a-b)] += arrayB[i];
            }
            while (arrayA[count] == 0) {

                count++;
            }
            arrayC = arrayA;
        }
        for (int i = 0; i < arrayC.length; i++) {
            if (arrayC[i] != 0) {
                System.out.println(arrayC.length - 1 - i);
                break;
            }
        }
        System.out.println(String.join(" ", Arrays.stream(arrayC).mapToObj(String::valueOf).toArray(String[]::new)));
    }
    //

    // Решение задачи С из блока "Задача «сумма двух чисел»"
    public static void С(String[] args) {
        Scanner str = new Scanner(System.in);
        int n = Integer.parseInt(str.nextLine());
        String arrayA = str.nextLine();
        String arrayB = str.nextLine();
        ArrayList<String> itog = new ArrayList<String>();
        char[] arrayC = new char[2 * n];
        for (int i = 0; i < n; i++) {
            arrayC[2*i] = arrayA.charAt(i);
            arrayC[2*i+1] = arrayB.charAt(i);
        }
        System.out.println(new String(arrayC));
    }
    //

    // Решение задачи D из блока "Задача «сумма двух чисел»"
    public static void D(String[] args) {
        Scanner str = new Scanner(System.in);
        String[] stroke = str.nextLine().split(" ");
        int n = Integer.parseInt(stroke[0]);
        int m = Integer.parseInt(stroke[1]);
        String[][] arr1 = new String[n][m];
        String[][] arr2 = new String[n][m];
        String[] summ = new String[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = str.nextLine().split(" ");
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = str.nextLine().split(" ");
        }
        int[] sumArr = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                summ[j] = String.valueOf(Integer.parseInt(arr1[i][j]) + Integer.parseInt(arr2[i][j]));
            }
            System.out.println(String.join(" ",summ));
        }
    }
    //
}