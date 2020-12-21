package 排序算法.quicksort;

import org.junit.Test;
import 排序算法.heap.heapSort;
import 排序算法.merge.MyMergeSort;

import java.io.*;

/**
 * @author zxs666
 * @date 2020/11/11 19:14
 */
public class AlogramTest1 {


    //比较几种排序算法的时间
    @Test
    public void compareTime() throws IOException {

        long quickSortTime=quickSortTime();
        System.out.println("快速排序："+quickSortTime+"ms");

        long mergeSortTime=mergeSortTime();
        System.out.println("归并："+mergeSortTime+"ms");

        long heapSortTime=heapSortTime();
        System.out.println("堆排："+heapSortTime+"ms");

        long bubbleSortTime=bubbleSortTime();
        System.out.println("冒泡："+bubbleSortTime+"ms");

    }

    //快排
    public long quickSortTime() throws IOException {
        int[] nums = readFile();
        //System.out.println(Arrays.toString(nums));
        QuickSort qs = new QuickSort();
        long start = System.currentTimeMillis();
        qs.quickSortWithRandom(nums);
        long end = System.currentTimeMillis();

        WriteFile(nums, "C:\\Users\\admin\\Desktop\\算法实验\\实验一快排及改进\\quickSorted.txt");
        //System.out.println("对于给定数据，使用改良快排的运行时间为:"+(end-start));
        long length = end - start;
        return length;
    }

    //归并
    public long mergeSortTime() throws IOException {
        int[] nums = readFile();
        //System.out.println(Arrays.toString(nums));
        MyMergeSort ms = new MyMergeSort();
        long start = System.currentTimeMillis();
        ms.mergeSort(nums);
        long end = System.currentTimeMillis();

        WriteFile(nums, "C:\\Users\\admin\\Desktop\\算法实验\\实验一快排及改进\\mergeSorted.txt");

        long length = end - start;
        return length;
    }

    //堆排序
    public long heapSortTime() throws IOException {
        int[] nums = readFile();
        //System.out.println(Arrays.toString(nums));
        heapSort hs = new heapSort();
        long start = System.currentTimeMillis();
        hs.heapSort(nums);
        long end = System.currentTimeMillis();

        WriteFile(nums, "C:\\Users\\admin\\Desktop\\算法实验\\实验一快排及改进\\heapSorted.txt");

        long length = end - start;
        return length;
    }

    //冒泡排序
    public long bubbleSortTime() throws IOException {
        int[] nums = readFile();
        //System.out.println(Arrays.toString(nums));
        BubbleSort bs = new BubbleSort();
        long start = System.currentTimeMillis();
        bs.bubbleSort(nums);
        long end = System.currentTimeMillis();

        WriteFile(nums, "C:\\Users\\admin\\Desktop\\算法实验\\实验一快排及改进\\bubbleSorted.txt");

        long length = end - start;

        // System.out.println("对于给定元素冒泡排序的运行时间为:"+length);
        return length;
    }

    @Test
    public void test2() throws IOException {
        int N = 1;
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += quickSortTime();
        System.out.println("对数据排序" + N + "次所花时间为：" + sum + ",平均时间：" + sum / N);

    }

    public int[] readFile() throws IOException {
        File file = new File("C:\\Users\\admin\\Desktop\\算法实验\\实验一快排及改进\\data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));//构造一个BufferedReader类来读取文件
        String s = null;
        int number = Integer.valueOf(br.readLine());

        int[] nums = new int[number];
        String[] strs = br.readLine().split(" ");
        //System.out.println("strs："+strs.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }

        return nums;
    }


    public void WriteFile(int nums[], String filePath) throws IOException {
        File file = new File(filePath);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));//构造一个BufferedReader类来读取文件
        StringBuffer sb = new StringBuffer("");
        for (int num : nums)
            sb.append(num + " ");

        bf.write(sb.toString());
        bf.flush();
        ;
    }
}
