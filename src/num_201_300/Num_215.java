package num_201_300;

/**
 * Created by zxs666 on 2020/8/8.
 * 利用快排的二分进行查找第K个最大的元素
 */
public class Num_215 {
    public static void main(String[] args) {
        int max = 100, min = 0;
        for (int i = 0; i < 100; i++) {
            int ran2 = (int) (Math.random() * (max - min) + min);
            System.out.print(ran2 + " ");
        }

    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];
        //使用随机数作为关键字
        int mid = (int) (Math.random() * (end - start) + start);
        int temp = nums[mid];
        nums[mid] = nums[start];
        nums[start] = temp;

        int key = nums[start];
        int l = start;
        int r = end;
        //快排核心代码
        while (l < r) {
            while (l < r && nums[r] >= key)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= key)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = key;
        if (l == k)
            return key;
        else if (l < k)
            return quickSort(nums, r + 1, end, k);
        else
            return quickSort(nums, start, r - 1, k);
    }
}
