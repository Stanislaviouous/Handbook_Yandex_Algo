import java.util.*;
import java.util.stream.IntStream;

class Main {
    public static int solutionFast(int n, Integer[] prices, Integer[] clicks){
        Arrays.sort(prices);
        Arrays.sort(clicks);
        long loot = 0;
        for (int i = 0; i < n; i++) {
            loot += (long) clicks[i] * prices[i];
        }
        return (int) loot;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
////        int str[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
////        int n = str[0];
////        int W = str[1];
////        ArrayList<Integer> arr = new ArrayList<>();
//        int n = Integer.parseInt(sc.nextLine());
//        int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int[] clicks = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        System.out.println(solutionNative(n,
//                Arrays.stream(prices)
//                        .boxed()
//                        .toArray(Integer[]::new),
//                Arrays.stream(clicks)
//                        .boxed()
//                        .toArray(Integer[]::new)));

        stressTest(1000, 1000);
    }

    public static long solutionNative(int n, Integer[] prices, Integer[] clicks){
        long revenue = 0;
        ArrayList<Integer> clickes = new ArrayList<>(List.of(clicks));
        ArrayList<Integer> prics = new ArrayList<>(List.of(prices));
        while (!clickes.isEmpty()) {
            int p = -1;
            int q = -1;
            double maxiP = Integer.MIN_VALUE;
            double maxiQ = Integer.MIN_VALUE;
             for (int i = 0; i < clickes.size(); i++) {
                if (clickes.get(i) > maxiP) {
                    maxiP = clickes.get(i);
                    p = i;
                }
                 if (prics.get(i) > maxiQ) {
                     maxiQ = prics.get(i);
                     q = i;
                 }
            }
            revenue += prics.get(q) * clickes.get(p);
            clickes.remove(p);
            prics.remove(q);
        }
        return revenue;
    }

    public static void stressTest(int N, int M) {
        Random random = new Random();
        while(true) {
            int n = random.nextInt(N - 2 + 1) + 2;
            Integer[] arrTest1 = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrTest1[i] = random.nextInt(M - 2 + 1) + 2;
            }
            Integer[] arrTest2 = new Integer[n];
            for (int i = 0; i < n; i++) {
                arrTest2[i] = random.nextInt(M - 2 + 1) + 2;
            }

            long result_1 = solutionNative(n, arrTest1, arrTest2);
            long result_2 = solutionFast(n, arrTest1, arrTest2);

            if (result_1 == result_2) {
                System.out.println("OK");
            } else {
                System.out.println(result_1 + " " + result_2);
                System.out.println("Wrong answer!");
                return;
            }
        }
    }

}


//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        long[] arr = Arrays.stream(sc.nextLine().split(" "))
//                .mapToLong(Long::parseLong)
//                .toArray();
//        System.out.println(solutionFast(n, arr));
//        stressTest(100, 1000000000);


//            System.out.println(arr.size() + " " + arr.stream()
//                    .map(Object::toString)
//                    .collect(Collectors.joining(" ")));