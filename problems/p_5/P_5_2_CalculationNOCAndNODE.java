package problems.p_5;

public class P_5_2_CalculationNOCAndNODE {

    // Решение задачи A из блока "Вычисление НОК и НОД"
    public static int A(int a, int b) {
        int gcd = 1;
        while (a > 0 && b > 0) {
            if (b > a) {
                b = b % a;
            }
            else {
                a = a % b;
            }
        }
        return (int) Double.max(a, b);
    }
    //

    // Решение задачи B из блока "Вычисление НОК и НОД"
    public static long B(long a, long b) {
        long pay = (long) a * b;
        while (a > 0 && b > 0) {
            if (b > a) {
                b = b % a;
            }
            else {
                a = a % b;
            }
        }
        return (pay / (long) Double.max(a, b));
    }
    //

    // Решение задачи C из блока "Вычисление НОК и НОД"
    public static String C(long n) {
        if (n <= 1){
            return String.valueOf(n) + " " + n;
        }
        int previous = 0;
        int current = 1;
        int oldPrevious = -1;
        while (current <= n){
            oldPrevious = previous;
            previous = current;
            current = (oldPrevious + previous);
        }
        return oldPrevious + " " + previous;
    }
    //

}
