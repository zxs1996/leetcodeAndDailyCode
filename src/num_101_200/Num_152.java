package num_101_200;

/**
 * Created by zxs666 on 2020/7/28.
 */
public class Num_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = nums[0];
        int min = nums[0];//记录前面的最小,因为你有可能出现负数的情况
        int max = nums[0];//记录前面的最大，
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            //更新最大值
            max = Math.max(min * nums[i], max * nums[i]);
            max = Math.max(max, nums[i]);
            //更新最小值
            min = Math.min(min * nums[i], temp * nums[i]);
            min = Math.min(min, nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
