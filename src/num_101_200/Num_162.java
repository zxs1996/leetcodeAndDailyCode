package num_101_200;

/**
 * Created by zxs666 on 2020/7/28.
 */
public class Num_162 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        int res = new Num_162().findPeakElement(nums);
        System.out.println(res);
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        return repeat(nums, 0, nums.length - 1);
    }

    public int repeat(int[] nums, int l, int r) {
        if (l > r)
            return -1;
        int mid = (l + r) / 2;

        if (mid == 0 && nums[mid] > nums[mid + 1])
            return 0;
        if (mid == nums.length - 1 && nums[mid] > nums[mid - 1])
            return nums.length - 1;
        if (mid>0&&mid<nums.length-1&&nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;
        int left = repeat(nums, l, mid-1);
        if (left != -1)
            return left;
        int right = repeat(nums, mid+1, r);
        if (right != -1)
            return right;
        return -1;
    }
}
