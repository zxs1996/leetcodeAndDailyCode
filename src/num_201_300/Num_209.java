package num_201_300;

/**
 * Created by zxs666 on 2020/8/1.
 */
public class Num_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        //end不到边界，或者sum>s，sum>s时，start可以往右渐进
        while (end < nums.length || sum >= s) {
            //end往右移动
            if (sum < s) {
                sum += nums[end++];
            } else {
                //刷新min
                min = Math.min(min, end - start);
                //start往右移动
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE?0:min;

    }
}
