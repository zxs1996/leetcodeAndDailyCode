package 力扣_201_300;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by zxs666 on 2020/8/8.
 * 利用快排的二分进行查找第K个最大的元素
 */
public class Num_215 {
    @Test
    public void test() {
        int max = 100, min = 0;
        for (int i = 0; i < 100; i++) {
            int ran2 = (int) (Math.random() * (max - min) + min);
            System.out.print(ran2 + " ");
        }
    }

    /**
     * 使用快排的分治解决
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    //找排序后下标为K的元素
    public int quickSort(int[] nums, int left, int right, int k) {
        if (left == right)
            return nums[left];
        int partition = partition(nums, left, right);
        if (partition == k)
            return nums[partition];
        else if (partition > k)
            return quickSort(nums, left, partition - 1, k);
        else return quickSort(nums, partition + 1, right, k);

    }


    public int partition(int[] nums, int left, int right) {
        int r = new Random().nextInt(right - left + 1) + left;
        swap(nums, r, right);

        int key = nums[right];
        int par = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] < key)
                swap(nums, ++par, i);
        }
        swap(nums, ++par, right);
        return par;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 使用堆排序解决
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i < k; i++)
            pq.add(nums[index++]);
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }


}
