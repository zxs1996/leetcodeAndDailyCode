package 动态规划;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/11/24 22:00
 * <p>
 * 0 1 背包
 */
public class Package01 {

    @Test
    public void test() {
        int sum = 100;
        int[] weight = {77, 22, 29, 50, 99};
        int[] value = {92, 22, 87, 46, 90};
        int res = getMax(value, weight, sum);
        System.out.println(res);
        System.out.println(getMaxWithYIWEI(value, weight, sum));
    }


    /**
     * 使用二维数组的0 1背包
     */

    public int getMax(int[] value, int[] weight, int sum) {
        int n = value.length;
        if (n == 0)
            return 0;
        //dp[i][j]表示在前i个物品的情况下,j容量背包能够取得的最大价值
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = weight[i - 1]; j <= sum; j++) {
                //选择当前商品或者不选当前商品
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
            }
        }
        return dp[n][sum];
    }


    /**
     * 使用一维数组的0 1背包
     */

    public int getMaxWithYIWEI(int[] value, int[] weight, int sum) {

        if (value.length == 0)
            return 0;
        int[] dp = new int[sum + 1];//dp[i]表示在当前循环下容量为i的背包所能获得的最大值，每轮循环隐式给出
        for (int i = 0; i < weight.length; i++) {
            //必须从后往前，只用循环到weight[i]，因为再往前背包变小，必然不能i对应的物品放入
            //从后往前，是为了不使用覆盖后的数据
            for (int j = sum; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[sum];
    }
}
