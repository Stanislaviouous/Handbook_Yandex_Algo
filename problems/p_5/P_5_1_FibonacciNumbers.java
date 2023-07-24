package problems.p_5;

import java.util.Arrays;
import java.util.List;

public class P_5_1_FibonacciNumbers {

    // Решение задачи A из блока "Задачи о числах Фибоначчи"
    public static long A(int n) {
        if (n <= 1){
            return n;
        }
        int previous = 0;
        int current = 1;
        int oldPrevious = -1;
        for (int i = 0; i < n - 1; i++) {
            oldPrevious = previous;
            previous = current;
            current = (oldPrevious + previous);
        }
        return current;
    }
    //

    // Решение задачи B из блока "Задачи о числах Фибоначчи"
    public static long B(int n) {
        long[] F = new long[(int) (n + 1)];
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            F[i] = (F[i - 1] + F[i -2]) % 10;
        }
        return F[(int) n];
    }
    //

    // Решение задачи С из блока "Задачи о числах Фибоначчи"
    public static long C(long n, long m) {
        long current = 0;
        long next = 1;
        int period = 0;
        long oldNext = -1;
        while (true){
            oldNext = next;
            next = (current + next) % m;
            current = oldNext;
            period = period + 1;
            if ((current == 0) && (next == 1)){
                break;
            }
        }
        n = n % period;
        long[] F = new long[(int) (n + 1)];
        if (n == 0){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            F[i] = (F[i - 1] + F[i -2]) % m;
        }
        return F[(int) n];
    }
    //

    // Решение задачи D из блока "Задачи о числах Фибоначчи"
    public static long D(long k) {
        long n = (k + 2) % 60;
        long[] F = new long[(int) (n + 1)];
        F[0] = 0;
        if (n > 0){
            F[1] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            F[i] = (F[i - 1] + F[i - 2]) % 10;
        }
        if (F[(int) n] == 0){
            return 9;
        }
        return F[(int) n] - 1;
    }
    //

    // Решение задачи E из блока "Задачи о числах Фибоначчи"
    public static long E(long m, long n) {
        return (10 + E_summ(n) - E_summ(m - 1)) % 10;
    }
    public static long E_summ(long k) {
        long n = (k + 2) % 60;
        long[] F = new long[(int) (n + 1)];
        F[0] = 0;
        if (n > 0){
            F[1] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            F[i] = (F[i - 1] + F[i - 2]) % 10;
        }
        if (F[(int) n] == 0){
            return 9;
        }
        return F[(int) n] - 1;
    }
    //

}
