package algCourse;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zxs666
 * @date 2020/11/24 9:51
 */
public class BinarySearch {

    @Test
    public void test() {
        int N = 100000;
        int nums[] = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = i + 1;
        int ranIndex = new Random().nextInt(N);
        nums[ranIndex] = N + 1;

        System.out.println(Arrays.toString(nums));
        long start=System.currentTimeMillis();
        System.out.println(Sum(nums));
        long end=System.currentTimeMillis();
        System.out.println("数学求和:"+(end-start)+" ms");

        start=System.currentTimeMillis();
        System.out.println(findBySwap(nums));
        end=System.currentTimeMillis();
        System.out.println("基于交换："+(end-start)+" ms");
        //System.out.println(binarySearch(new int[]{9}, 9));
    }


    public int findBySwap(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[i] != n + 1)
                swap(nums, i, nums[i] - 1);
        }
        /*for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;*/
        return n + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int Sum(int[] nums) {
        int n = nums.length;

        int sum = (1 + n) *n/2+n+1 ;
        System.out.println(sum);
        System.out.println("Integer.MAX_VALUE："+Integer.MAX_VALUE);
        for (int num : nums)
            sum -= num;
        return sum;
    }

    public int binarySearch(int[] nums, int x) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == x)
                return mid;
            else if (nums[mid] > x)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return Math.abs(nums[l] - x) < Math.abs(nums[r] - x) ? l : r;
    }
}
