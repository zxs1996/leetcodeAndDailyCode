package num_1_100;

/**
 * Created by zxs666 on 2020/7/1.
 */
public class Num_35 {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0)
            return 0;
        int l = 0, r = length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            //相等
            if (target==nums[mid]  )
                return mid;
                //目标值小于中值,去左边找
            else if (target < nums[mid])
                r = mid - 1;
                //目标值大于中值，去右边找
            else
                l = mid + 1;
        }
        return l;
    }
}
