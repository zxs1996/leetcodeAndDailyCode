package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/22.
 */
public class Num_153 {

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            //左边有序
            if (nums[l] <= nums[mid]) {
                //找到左边最小值
                res = Math.min(res, nums[l]);
                //去右边找
                l = mid + 1;

            }
            //右边有序
            else if (nums[mid] <= nums[r]) {
                res = Math.min(res, nums[mid]);
                //去左边找
                r = mid - 1;
            }
        }
        return res;
    }

}
