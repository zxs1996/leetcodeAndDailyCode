package 力扣_401_500;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/9/22 22:20
 */
public class Num_486 {

    @Test
    public void test() {
        int nums[]={1, 5, 233, 7};
        boolean res=PredictTheWinner(nums);
        System.out.println(res);

    }

    public boolean PredictTheWinner(int[] nums) {
        //sum[i][j]表示从i到j的元素总和
        int sum[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++)
            for (int j = i; j < nums.length; j++)
                for (int k = i; k <= j; k++)
                    sum[i][j] += nums[k];

        //dp[i][j]表示从i到j玩家1能够拿到的最大值
        int[][] dp = new int[nums.length][nums.length];
        //初始化只有一个元素
        for (int i = 0; i < nums.length; i++)
            dp[i][i] = nums[i];
        //从两个元素开始，一直到整个数组长度
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                dp[j][j + i] = Math.max(nums[j] + sum[j + 1][j + i] - dp[j + 1][j + i], nums[j + i] + sum[j][j + i - 1] - dp[j][j + i - 1]);
            }
        }

        return dp[0][nums.length-1] * 2 >= sum[0][nums.length-1];

    }
}
