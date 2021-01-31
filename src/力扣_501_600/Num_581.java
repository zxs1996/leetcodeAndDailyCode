package 力扣_501_600;

/**
 * @author zxs666
 * @date 2021/1/2 12:14
 */
public class Num_581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        //从左往右计算最大值
        int[] max = new int[n];
        max[0] = nums[0];
        for (int i = 1; i < n; i++)
            max[i] = Math.max(nums[i], max[i - 1]);

        //从右往左计算最小值
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            min[i] = Math.min(nums[i], min[i + 1]);

        int i = 0;
        while (i < n && max[i] <= min[i])
            i++;

        int j = n - 1;
        while (j >= 0 && max[j] <= min[j])
            j--;

        //如果全部有序，那么j必然小于i，j-i+1是负数，那么取0即可
        return Math.max(j - i + 1,0);
    }
}
