package package_01;

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
        int[][] dp = new int[n][sum + 1];
        //初始化边界
        for (int i = weight[0]; i <= sum; i++)
            dp[0][i] = value[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                //先继承前一个的值
                dp[i][j] = dp[i - 1][j];
                if (j > weight[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[n - 1][sum];
    }


    /**
     * 使用一维数组的0 1背包
     */

    public int getMaxWithYIWEI(int[] value, int[] weight, int sum) {
        int n = value.length;
        if (n == 0)
            return 0;
        int[] dp = new int[sum + 1];//dp[i]表示在当前情况下容量为i的背包所能获得的最大值，每轮循环隐式给出
        //初始化边界
        for (int i = weight[0]; i <= sum; i++)
            dp[i] = value[0];
        for (int i = 1; i < n; i++) {
            //必须从后往前，只用循环到weight[i]，因为再往前背包变小，必然不能i对应的物品放入
            for (int j = sum; j >= weight[i]; j--) {
                //大于的情况才判断
                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[sum];
    }
}
