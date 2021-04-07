package 剑指offer;

import org.junit.Test;

import java.util.*;
import java.util.function.DoubleToLongFunction;

/**
 * @author zxs666
 * @date 2021/3/30 23:58
 * <p>
 * 如果用dfs做的话，会超时，
 * 使用二维数组dp
 */
public class Num_60 {


    public double[] dicesProbability(int n) {

        int max = n * 6;//最大值
        int[][] dp = new int[n + 1][max + 1];
        double all = Math.pow(6, n);//总共的情况
        //初始化只有一个骰子的情况
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //dp[i][j]表示使用i个骰子能够拼出j的次数
        for (int i = 1; i <= n; i++) {
            //j从i开始，因为最少取1
            for (int j = i; j <= 6 * i; j++) {
                //每个骰子有6中情况
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] +=j > k ? dp[i - 1][j - k] : 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        List<Double> list = new ArrayList<>();

        for (int i = n; i <= n * 6; i++) {

            list.add(dp[n][i] / all);
        }

        double[] res = new double[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    @Test
    public void test(){
        double res[]=dicesProbability(1);
        System.out.println(Arrays.toString(res));
    }


}
