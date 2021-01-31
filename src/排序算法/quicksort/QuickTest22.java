package 排序算法.quicksort;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zxs666
 * @date 2021/1/31 14:57
 */
public class QuickTest22 {

    @Test
    public void test() {
        int N = 100;
        int[] nums1 = new int[N];
        int[] nums2 = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            nums1[i] = nums2[i] = random.nextInt(100);
        }
        Arrays.sort(nums1);
        quickSort(nums2, 0, nums2.length - 1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        for (int i = 0; i < N; i++)
            if (nums1[i] != nums2[i])
                System.out.println("bug bug");
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {

        //1 取随机数,交换基准值
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, random, right);

        int i = left - 1;//这个i表示的是最后一个比key小的元素的下标，初始为left-1
        int key = nums[right];
        for (int j = left; j < right; j++) {
            if (nums[j] < key)
                swap(nums, ++i, j);
        }
        swap(nums, ++i, right);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
