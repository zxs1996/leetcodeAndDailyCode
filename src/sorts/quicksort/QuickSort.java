package sorts.quicksort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    static Random random = new Random();
    private final int INSERT_FACTOR = 20;//低于多少开始使用插入排序
    private final int RANDOM_NUMBER = 3;//产生的随机数个数，其中两个来源于left和right

    /**
     * 提供对外的接口
     * @param nums
     */
    public void quickSortWithRandom(int[] nums) {
        quickSortWithRandom(nums, 0, nums.length - 1);

    }

    /**
     * 实际的快排函数
     * @param nums
     * @param left
     * @param right
     */
    private void quickSortWithRandom(int[] nums, int left, int right) {

        //当规模小于指定规模时，使用插入排序
        if (left + INSERT_FACTOR >= right) {
            insertSort(nums, left, right);
        }
        //否则使用快排
        else if (left < right) {
            //partition将数组划分成左右两部分
            int mid = partitionWithMultipleRandom(nums, left, right);
            //左右两个子数组继续递归地做相同的处理
            quickSortWithRandom(nums, left, mid - 1);
            quickSortWithRandom(nums, mid + 1, right);
        }
    }

    //未改进的快排
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        //partition
        int mid = partition2(nums, left, right);

        //继续向下递归
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }


    /**
     * 插入排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = nums[i];
            int j = i - 1;
            for (; j >= left && key < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = key;
        }
    }


    //从左到右双指针，以最右边元素为关键值，
    //算法导论的partition方式
    //使用随机数改进，使用一个随机数
    private int partitionWithRandom(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;  //产生随机数，
        int[]arr={nums[left],nums[right],nums[random]};//将最左值、最右值和随机值放入数组
        ranArr(nums, arr);//对这个数组排序
        //交换right和random
        swap(nums, arr[1], right);//选择中位数和最右值交换

        //使用最右值作为key
        int key = nums[right];
        //i表示小于key的最后一个元素的下标，通过i将数组分成左右两部分，i以及i左边的小于key，i右边的大于key
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < key)
                swap(nums, ++i, j);
        }
        swap(nums, ++i, right);
        return i;
    }


    //使用多个随机数，3个随机数+头尾共5个数，取中间值
    private int partitionWithMultipleRandom(int[] nums, int left, int right) {
        int[] arr = new int[RANDOM_NUMBER];
        arr[0] = left;
        arr[1] = right;
        for (int i = 2; i < RANDOM_NUMBER; i++)
            arr[i] = random.nextInt(right - left + 1) + left;
        ranArr(nums, arr);
       /* for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"-"+nums[arr[i]]+"  ");
        System.out.println();*/
        //交换right和random
        swap(nums, arr[RANDOM_NUMBER/2], right);

        //使用最右值作为key
        int key = nums[right];
        //i表示小于key的最后一个元素的下标，通过i将数组分成左右两部分，i以及i左边的小于key，i右边的大于key
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < key)
                swap(nums, ++i, j);
        }
        swap(nums, ++i, right);
        return i;
    }

    /**
     * @param numbers
     * @param arr     对随机数进行一个重排序
     */
    private void ranArr(int[] numbers, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (numbers[arr[j]] < numbers[arr[minIndex]])
                    minIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //未使用随机数改进的partition
    private int partition2(int[] nums, int left, int right) {

        int key = nums[right];
        //i表示小于key的最后一个元素的下标，通过i将数组分成左右两部分，i以及i左边的小于key，i右边的大于key
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < key)
                swap(nums, ++i, j);
        }
        swap(nums, ++i, right);
        return i;
    }


    //两侧渐进双指针，以最左边元素为关键值
    //以前的partition方式
    private int partition(int[] nums, int left, int right) {
        System.out.println("bound:" + (right - left + 1));
        //产生随机数random，交换left和random，避免最坏情况出现
        int random = new Random().nextInt(right - left + 1) + left;
        //交换random和left
        swap(nums, random, left);


        //将nums[left]作为key，
        int key = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= key)
                j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= key)
                i++;
            nums[j] = nums[i];
        }
        nums[i] = key;
        return i;
    }

    /**
     * 交换数组两个元素
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

  /*  {
        int random = left + (int) (Math.random() * (right - left + 1));
        int key = nums[random];
        nums[random] = nums[left];
        int low = left;
        int high = right;
        while (low < high) {
            while (low < high && nums[high] > key)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] < key)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = key;
    }*/

}
