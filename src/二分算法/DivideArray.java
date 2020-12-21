package 二分算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/12/16 17:29
 */
public class DivideArray {

    @Test
    public void test() {
        int[] nums = {1, 3, 6, 8, 2, 13, 7, 9};

        System.out.println(divide(nums, nums.length));
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
    }


    int divide(int[] nums, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];

        int left = 0, right = n - 1;
        while (true) {
            int low = left, high = right;
            int piovtKey = nums[low];
            while (low < high) {
                while (low < high && nums[high] > piovtKey)
                    high--;
                nums[low] = nums[high];
                while (low < high && nums[low] <= piovtKey)
                    low++;
                nums[high] = nums[low];
            }
            nums[low] = piovtKey;
            int s1 = 0;
            for (int i = 0; i <= low; i++)
                s1 += nums[i];
            //刚好能够完美划分，那么直接返回
            if (low == n / 2 - 1) {
                System.out.println(Arrays.toString(nums));
                return Math.abs(sum - s1 - s1);
            } else if (low < n / 2 - 1) {

                left = low + 1;
            } else {

                right = low - 1;
            }
        }
    }
}
