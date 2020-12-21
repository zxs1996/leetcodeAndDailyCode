package 力扣_1_100;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/14.
 */
public class Num_75 {

    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        new Num_75().sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int count[] = {0, 0, 0};
        for (int i : nums)
            count[i]++;
        int index = 0;
        for (int i = 0; i < 3; i++)
            while (count[i]-- > 0)
                nums[index++] = i;
    }

    public void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int curr = 0;
        int temp;
        while (curr <= right) {
            //curr为0，这种情况left++,curr++，因为从left换过来的一定不是2
            if (nums[curr] == 0) {
                temp = nums[left];
                nums[left] = nums[curr];
                nums[curr] = temp;
                left++;
                curr++;
            } //curr为2，right--，curr不++,因为从right换过来的有可能是一个2，那么curr不能增，得继续往右边换
            else if (nums[curr] == 2) {
                temp = nums[right];
                nums[right] = nums[curr];
                nums[curr] = temp;
                right--;
            }
            //只有在nums[curr]为1的时候，curr++
            else
                curr++;
        }
    }
}
