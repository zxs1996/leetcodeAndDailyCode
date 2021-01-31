package 力扣_401_500;

import org.junit.Test;

import java.util.Arrays;


//这道题可以使用动态规划做，也可以使用贪心算法做
public class Num_410 {

    @Test
    public void test2() {
        int[] nums = {7, 2, 5, 10, 8};
        int res = splitArray(nums, 2);
        System.out.println(res);
    }

    //动态规划
    public int splitArray(int[] nums, int m) {
        //sum[i]表示从0到i这个数组的总和
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];

        //开辟dp数组，dp[i][j]表示以i结尾的数组，分割成j份的最优值
        int[][] dp = new int[nums.length + 1][m + 1];
        //保留dp[0][x]为0，从1开始初始化
        for (int i = 1; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);//初始化成最大值

        //从1开始分割，一直到m份
        for (int i = 1; i <= m; i++) {
            //循环数组长度，计算每一个dp[j][i]，
            for (int j = i; j <= nums.length; j++)
                //往前递归找，将0到k分成m-1份，k+1到j作为一份，
                for (int k = j - 1; k >= i - 1; k--) {
                    //如果后面k-j这一份超过了dp[j][i]，那么直接break
                    if (sum[j] - sum[k] >= dp[j][i])
                        break;
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i - 1], sum[j] - sum[k]));
                }

        }
        System.out.println(dp[1][1]);
        return dp[nums.length][m];
    }



}
