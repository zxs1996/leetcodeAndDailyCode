package 力扣_1_100;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/6/27.
 */
public class Num_31 {

    public static void main(String[] args) {
        //int[] nums = {4, 2, 0, 2, 3, 2, 0};
        int[] nums = {1,2,3};
        new Num_31().nextPermutation(nums);
        for (int i : nums)
            System.out.print(i + " ");


    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        //特殊值，直接返回
        if (length <= 1)
            return;
        for (int i = length - 2; i >= 0; i--) {
            int index = -1;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] > nums[i]) {
                    if (index == -1 || nums[j] < nums[index])
                        index = j;
                }
            }
            if (index != -1) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                Arrays.sort(nums, i + 1, length);
                return;
            }
        }
        //排序
        Arrays.sort(nums);
    }
}
