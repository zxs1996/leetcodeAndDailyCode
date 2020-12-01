package num_101_200;

/**
 * Created by zxs666 on 2020/7/22.
 */
public class Num_154 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (l <=r) {
            int mid = (l + r) / 2;
            //如果中间值小于右侧值，说明右侧是有序的，左侧无序
            if (nums[mid] < nums[r]) {
                res = Math.min(res, nums[mid]);
                r = mid - 1;
            }
            //如果中间值大于nums[r]，说明右侧无序,左侧是有序的，，
            else if (nums[mid] > nums[r]) {
                res = Math.min(res, nums[l]);
                l = mid + 1;
            }
            //最右侧值等于中间值，无法判断那边有序，让r--，因为mid可以替代r
            else {
                res = Math.min(res, nums[mid]);
                r--;
            }
        }
        return res;
    }

}
