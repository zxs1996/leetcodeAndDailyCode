package 力扣_101_200;

/**
 * @author zxs666
 * @date 2021/1/8 23:22
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 必须要求原地算法
 */
public class Num_189 {

    //解法1，先整体翻转，在翻转前半段，再翻转后半段

    public void rotate(int[] nums, int k) {
        //1、先整体翻转
        reverse(nums, 0, nums.length-1);
        //2、翻转左半部分
        reverse(nums,0,k-1);
        //3、翻转右部分
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
