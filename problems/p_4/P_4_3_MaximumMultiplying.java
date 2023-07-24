package problems.p_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P_4_3_MaximumMultiplying {
    // Решение задачи A из блока "Задача «Максимальное произведение»"
    public static long A(int n, long[] arr){
        long mex = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if(mex < arr[i]) {
                mex = arr[i];
                index = i;
            }
        }
        long m = mex;
        mex = 0;
        for (int i = 0; i < n; i++) {
            if(mex < arr[i] && i != index) {
                mex = arr[i];
            }
        }
        return (long)mex * (long)m;
    }
    //

    // Решение задачи B из блока "Задача «Максимальное произведение»"
    // Суть в том, что { 2(n - 2) + 1 > 1.5n } это условие выполняеться только после 6ти
    // Это справедливо, так как на первые 2 элемента приходиться 1 сравнение.
    // На элементы 3..N - в худшем случае приходиться 2 сравнения.
    public static void B(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = n;
        for (int i = 2; i < n; i++) {
            arr[i] = i;
        }
        if (n > 2) {
            System.out.println("YES");
            System.out.println(
                    String.join(
                            " ",
                            Arrays.stream(arr)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new)
                    )
            );
            return;
        }
        System.out.println("NO");
        return;
    }
    //

    // Решение задачи С из блока "Задача «Максимальное произведение»"
    public static long C(int n, long[] arr){
        long mex = Long.MIN_VALUE;
        long[] arrSort = Arrays.stream(arr).sorted().toArray();

        long down = arrSort[0] * arrSort[1];
        long up = arrSort[n - 1] * arrSort[n - 2];

        for (int i = 2; i < n; i++) {
            if (mex < down * arrSort[i]) {
                mex = down * arrSort[i];
            }
        }
        for (int i = 0; i < n - 2; i++) {
            if (mex < up * arrSort[i]) {
                mex = up * arrSort[i];
            }
        }
        return mex;
    }
    //

    // Решение задачи D из блока "Задача «Максимальное произведение»"
    public static long D(int n, long[] arr) {
        long mex = Long.MIN_VALUE;
        long[] arrSort = Arrays.stream(arr).sorted().toArray();
        long[] variants = new long[]{
                arrSort[0] * arrSort[1] * arrSort[2],
                arrSort[0] * arrSort[1] * arrSort[n-1],
                arrSort[0] * arrSort[n-2] * arrSort[n-1],
                arrSort[n - 3] * arrSort[n - 2] * arrSort[n - 1]};
        Integer[][] indexVariants = new Integer[][]{
                new Integer[]{0,1,2},
                new Integer[]{0,1, n-1},
                new Integer[]{0, n-2, n-1},
                new Integer[]{n - 3, n - 2, n - 1}
        };
        for (int i = 0; i < 4; i++) {
            List<Integer> integers = Arrays.asList(indexVariants[i] );
            for (int j = 0; j < n; j++) {
                if ((!integers.contains(j)) && mex < arrSort[j] * variants[i]){
                    mex = arrSort[j] * variants[i];
                }
            }
        }

        return mex;
    }
    //
}
