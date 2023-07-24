package recipes;

import java.util.Arrays;
        import java.util.Random;
        import java.util.Scanner;

// Пример стресс тестирования
class StressTest {
    public static long solutionNative(int n, long[] arr){
        long mex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (mex < (long) arr[i] * arr[j]) {
                        mex = (long) arr[i] * arr[j];
                    }
                }
            }
        }
        return mex;
    }

    public static long solutionFast(int n, long[] arr){
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        long[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        System.out.println(solutionFast(n, arr));
//        stressTest(100, 1000000000);
    }

    public static void stressTest(int N, int M) {
        Random random = new Random();
        while(true) {
            int n = random.nextInt(N - 2 + 1) + 2;
            long[] arrTest = new long[n];
            for (int i = 0; i < n; i++) {
                arrTest[i] = random.nextInt(M - 2 + 1) + 2;
            }
            long result_1 = solutionNative(n, arrTest);
            long result_2 = solutionFast(n, arrTest);
            if (result_1 == result_2) {
                System.out.println("OK");
            } else {
                System.out.println("Wrong answer!");
                return;
            }
        }
    }
    
}

