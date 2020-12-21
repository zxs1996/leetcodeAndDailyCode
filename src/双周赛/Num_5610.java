package 双周赛;

/**
 * @author zxs666
 * @date 2020/12/12 22:36
 */
public class Num_5610 {


    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];

        int[] res = new int[n];
        res[0] = sum[n - 1] - nums[0] * n;
        for (int i = 1; i < n; i++) {
            res[i] = sum[n - 1] - sum[i] - (n - 1 - i) * nums[i]+i*nums[i]-sum[i-1];
        }

        return res;
    }
}
