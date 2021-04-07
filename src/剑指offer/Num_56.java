package 剑指offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2021/3/29 13:07
 *
 * 数组中有两个数只出现了一次，其余的都出现了两次。
 * 先异或得到这两个数，这两个数一定有一位不相同，按照这一位，将数组分成两段，前半段对应位都是0，后半段都是0.
 * 然后前后半段各自做异或得到最终结果
 */
public class Num_56 {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res = res ^ nums[i];


        //找res哪个位置上为1，将1 2 4 8.。。。与res做按位与，如果结果为1，说明对应位置为1。这一位用来区分两个不同的位
        int key = 1;
        while ((key & res) == 0)
            key *= 2;

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if ((nums[i] & key) > 0) {
                swap(nums, i, j);
                j--;
            } else
                i++;
        }

        int num1 = 0;
        for (int k = 0; k <= j; k++)
            num1 ^= nums[k];
        int num2 = 0;
        for (int k = j + 1; k < nums.length; k++)
            num2 ^= nums[k];

        return new int[]{num1, num2};
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


    @Test
    public void tes() {
        int[] arr = {4, 1, 4, 6};

        System.out.println(Arrays.toString(singleNumbers(arr)));
    }
}
