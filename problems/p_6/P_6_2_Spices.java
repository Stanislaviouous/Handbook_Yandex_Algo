package problems.p_6;

import java.util.ArrayList;
import java.util.Collections;

public class P_6_2_Spices {
    // Решение задачи A из блока "Специи"
    public static String A(int n, int W, ArrayList<Integer> cArray, ArrayList<Integer> wArray){
        double maxLoot = 0;
        if ((W == 0) || (wArray.size() == 0)) {
            return String.format("%.4f", maxLoot);
        }
        double amount = 0;
        double value = 0;
        int m = -1;
        while (W > 0.0) {
            if (wArray.size() == 0) {
                break;
            }
            double maxi = Integer.MIN_VALUE;
            for (int i = 0; i < cArray.size(); i++) {
                if ((double) cArray.get(i) / wArray.get(i) > maxi) {
                    maxi = (double) cArray.get(i) / wArray.get(i);
                    m = i;
                }
            }
            amount = Math.min(wArray.get(m), W);
            value = ((double) cArray.get(m) * amount) / wArray.get(m);
            maxLoot += value;
            cArray.remove(m);
            wArray.remove(m);
            W -= amount;
        }
        return String.format("%.3f", maxLoot);
    }
    //

    // Решение задачи B из блока "Специи"
    public static int B(int n, int W, ArrayList<Integer> arr){
        Collections.sort(arr);
        long loot = 0;
        for (int i = 0; i < n; i++) {
            loot += arr.get(i);
            if (loot > W) {
                return i;
            }
        }
        return 0;
    }
    //
}
