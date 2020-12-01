package num_101_200;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_198 {
    //不使用额外数组
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        int money1 = nums[0];
        int money2 = Math.max(nums[0], nums[1]);
        int max = Math.max(money1, money2);
        for (int i = 2; i < nums.length; i++) {
            money1 = Math.max(money1 + nums[i], money2);
            int temp = money1;
            money1 = money2;
            money2 = temp;
            max = Math.max(max, money2);
        }
        return max;
    }

    //使用额外数组
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];//dp[i]表示到第i家住户所能偷到的最大值
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        return dp[nums.length - 1];
    }
}
