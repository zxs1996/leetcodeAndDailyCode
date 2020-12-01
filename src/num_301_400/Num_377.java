package num_301_400;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Num_377 {

    @Test
    public void tes1() {
        int nums[] = {1, 2, 3};
        int res = combinationSum4(nums, 4);
        System.out.println(res);
    }

    public int combinationSum4(int[] nums, int target) {

        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int j = 0;j < nums.length&& nums[j] <= i ; j++)
                dp[i] += dp[i - nums[j]];

        return dp[target];
    }
}
