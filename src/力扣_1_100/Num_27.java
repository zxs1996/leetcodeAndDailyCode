package 力扣_1_100;

/**
 * Created by zxs666 on 2020/6/24.
 */
public class Num_27 {
    public static void main(String[] args) {
        int nums[]={1};
        System.out.println(new Num_27().removeElement(nums,1));
    }
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0, j = nums.length - 1; i <= j; i++) {
            //前面找到一个值为val的数，从后面找一个不为val的来填上这个空
            if (nums[i] == val) {
                count--;
                for (; i<j; j--) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        j--;
                        break;
                    } else
                        count--;
                }
            }
        }
        return count;
    }
}
