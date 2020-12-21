package 排序算法.quicksort;

/**
 * @author zxs666
 * @date 2020/11/17 16:32
 */
public class BubbleSort {

    public void bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
