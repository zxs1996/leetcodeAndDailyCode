package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/5.
 */
public class Num_41 {
    public static void main(String[] args) {
        int nums[] = {-3, 9, 16, 4, 5, 16, -4, 9, 26, 2, 1, 19, -1, 25, 7, 22, 2, -7, 14, 2, 5, -6, 1, 17, 3, 24, -4, 17, 15};
        System.out.println(new Num_41().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        int n = nums.length;

        for (int i = 0; i < n; i++)
            //如果是正数,且该值在n内，且不在正确的位置，那么交换位置
            // 注意这里难点在于使用while循环，使用while可以保证交换到i下标的元素，
            // 如果位置不正确，那么可以继续交换
            while (nums[i] > 0&&nums[i] <= n&&nums[nums[i]-1]!=nums[i])
                swap(nums,i,nums[i]-1);

        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }

    public void swap(int nums[], int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
