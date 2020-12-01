package num_201_300;

/**
 * Created by zxs666 on 2020/8/8.
 * * //可以简化成两种情况
 * 1、不偷窃第一家取得的最大值p1
 * 2、不偷窃最后一家取得的最大值p2
 * 3、返回两者中的较大值
 */
public class Num_213 {


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        //1、不偷窃最后一家取得的最大值
        int max1 = getMax(0, nums.length - 2, nums);
        //2、不偷窃第一家取得的最大值
        int max2 = getMax(1, nums.length - 1, nums);

        return Math.max(max1, max2);
    }

    public int getMax(int start, int end, int[] nums) {
        int money1 = nums[start];
        int money2 = Math.max(nums[start], nums[start + 1]);
        int max = money2;
        for (int i = start + 2; i <= end; i++) {
            money1 = Math.max(money1 + nums[i], money2);
            //交换money1 money2
            int temp = money1;
            money1 = money2;
            money2 = temp;
            max = Math.max(max, money2);
        }
        return max;
    }
}
