package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/15.
 */
public class Num_80 {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int count = 1;
        int key = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == key && count != 2) {
                count++;
                nums[index++] = nums[i];
            }
            if (nums[i] != key) {
                key = nums[i];
                count = 1;
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
