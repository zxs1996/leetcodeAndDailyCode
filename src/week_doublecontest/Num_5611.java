package week_doublecontest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zxs666
 * @date 2020/12/12 22:57
 */
public class Num_5611 {
    @Test
    public void test() {
        int[] alice = {9, 8, 3, 8};
        int[] bob = {10, 6, 9, 5};
        System.out.println(stoneGameVI(alice, bob));

    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] sum = new int[n][2];
        for (int i = 0; i < n; i++) {
            sum[i][0] = aliceValues[i] + bobValues[i];
            sum[i][1] = i;
        }
        Arrays.sort(sum, Comparator.comparingInt(o -> o[0]));
        int res = 0;
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            if (flag)
                res += aliceValues[sum[i][1]];

            else
                res-=bobValues[sum[i][1]];
            flag=!flag;
        }
        return res==0?0:res>0?1:-1;

    }
}