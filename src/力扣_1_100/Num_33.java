package 力扣_1_100;

/**
 * Created by zxs666 on 2020/6/28.
 */
public class Num_33 {

    public static void main(String[] args) {
        int nums[] = {5, 1, 3};
        System.out.println(new Num_33().search(nums, 0));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int l = 0, r = n - 1;
        //循环条件l<=r
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            //if 左边全部有序
            if (nums[0] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[0])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            //else 左边无序，说明右边有序
            else {
                if (nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
