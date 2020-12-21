import org.junit.Test;
import org.omg.CORBA.ARG_OUT;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zxs666
 * @date 2020/12/13 11:12
 */
public class Num_5245 {

    @Test
    public void test(){
        int[][] cuboids={{92,47,83},{75,20,87},{68,12,83},{12,85,15},{16,24,47},{69,65,35},{96,56,93},{89,93,11},{86,20,41},{69,77,12},{83,80,97},{90,22,36}};
        System.out.println(maxHeight(cuboids));

    }
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int i = 0; i < n; i++)
            Arrays.sort(cuboids[i]);
        Arrays.sort(cuboids, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.deepToString(cuboids));
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            dp[i][0] = cuboids[i][0];
            dp[i][1] = cuboids[i][1];
            dp[i][2] = cuboids[i][2];
            dp[i][3] = cuboids[i][2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //能够重叠上去
                if (cuboids[i][2] >= cuboids[j][2] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][0] >= cuboids[j][0]) {
                    dp[i][3] = Math.max(dp[i][3], dp[j][3] + cuboids[i][2]);
                }
            }
        }
        int res = 0;
        for (int[] tmp : dp) {
            res = Math.max(res, tmp[3]);
        }
        return res;
    }
}
