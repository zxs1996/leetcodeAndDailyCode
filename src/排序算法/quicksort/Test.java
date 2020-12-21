package 排序算法.quicksort;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author zxs666
 * @date 2020/11/11 15:01
 */
public class Test {


    @org.junit.Test
    public void sortTest() throws IOException {
        File file = new File("C:\\Users\\admin\\Desktop\\data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));//构造一个BufferedReader类来读取文件
        String s = null;
        int number = Integer.valueOf(br.readLine());

        int[] nums=new int[number];
        String[] strs=br.readLine().split(" ");
        System.out.println("strs："+strs.length);
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.valueOf(strs[i]);
        }
        for(int num:nums)
            System.out.print(num+" ");
    }

    @org.junit.Test
    public void sortTest22() throws IOException {
        File file = new File("C:\\Users\\admin\\Desktop\\data.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));//构造一个BufferedReader类来读取文件
        String s = null;
        int number = Integer.valueOf(br.readLine());

        int[] nums=new int[number];
        String[] strs=br.readLine().split(" ");
        System.out.println("strs："+strs.length);
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.valueOf(strs[i]);
        }
        for(int num:nums)
            System.out.print(num+" ");
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int number = 100000;
        Random random = new Random();
        int[] nums = new int[number];
        int[] nums2 = new int[number];
        for (int i = 0; i < number; i++) {
            nums[i] = nums2[i] = random.nextInt(100000);
            //nums[i] = nums2[i] = i + 1;
        }

        long start = 0, end = 0;
        //System.out.println(Arrays.toString(nums));
   /*     //未改进的时间
         start = System.currentTimeMillis();
        quickSort(nums, 0, number - 1);
         end = System.currentTimeMillis();
        System.out.println("未改进的快排花费:" + (end - start));*/

        start = System.currentTimeMillis();
        qs.quickSortWithRandom(nums);
        end = System.currentTimeMillis();
        System.out.println("改进后的快排花费时间:" + (end - start) + "ms");


        start = System.currentTimeMillis();
        Arrays.sort(nums2);
        end = System.currentTimeMillis();
        System.out.println("系统的Arrays.sort快排时间:" + (end - start) + "ms");

//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(nums2));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums2[i]) {
                System.out.println("wrong");
                return;
            }
        }
        System.out.println("correct");
        // System.out.println(Arrays.toString(nums));
    }

    public long[] compareTime() {
        QuickSort qs = new QuickSort();
        int number = 1000000;
        Random random = new Random();
        int[] nums = new int[number];
        int[] nums2 = new int[number];
        for (int i = 0; i < number; i++) {
            nums[i] = nums2[i] = random.nextInt(1000000);
            //nums[i] = nums2[i] = i + 1;
        }

        long start = 0, end = 0;
        //System.out.println(Arrays.toString(nums));
   /*     //未改进的时间
         start = System.currentTimeMillis();
        quickSort(nums, 0, number - 1);
         end = System.currentTimeMillis();
        System.out.println("未改进的快排花费:" + (end - start));*/

        start = System.currentTimeMillis();
        qs.quickSortWithRandom(nums);
        end = System.currentTimeMillis();
        // System.out.println("改进后的快排花费:" + (end - start));
        long myTime = end - start;


        start = System.currentTimeMillis();
        Arrays.sort(nums2);
        end = System.currentTimeMillis();
        //System.out.println("系统的快排：arrays:"+(end-start));

        //compareIsSame(nums,nums2);
        long arrTime = end - start;
        return new long[]{myTime, arrTime};

        // System.out.println(Arrays.toString(nums));
    }


    @org.junit.Test
    public void tenTimesCount() {
        int N = 1;
        int myTime = 0, arrTime = 0;
        for (int i = 0; i < N; i++) {
            long[] res = compareTime();
            myTime += res[0];
            arrTime += res[1];
        }
        System.out.println("百万数据自己的快排执行" + N + "次所耗费的时间：" + myTime + ",平均每次：" + (myTime / N));
        System.out.println("百万数据Arrays.sort快排执行" + N + "次所耗费的时间：" + arrTime + ",平均每次：" + (arrTime / N));
    }


    @org.junit.Test
    public void test() {
        QuickSort qs = new QuickSort();
        int number = 100;
        Random random = new Random();
        int[] nums = new int[number];
        int[] nums2 = new int[number];
        for (int i = 0; i < number; i++) {
            nums[i] = nums2[i] = random.nextInt(10000);
            //nums[i] = nums2[i] = i + 1;
        }

        //System.out.println(Arrays.toString(nums));
        //未改进的时间
        long start = System.currentTimeMillis();
        //qs.quickSort(nums, 0, number - 1);
        long end = System.currentTimeMillis();
        System.out.println("未改进的快排花费:" + (end - start));
        System.out.println(Arrays.toString(nums));

        start = System.currentTimeMillis();
        qs.quickSortWithRandom(nums2);
        end = System.currentTimeMillis();
        System.out.println("改进后的快排花费:" + (end - start));
        // System.out.println(Arrays.toString(nums));
    }

    public void compareIsSame(int[] nums, int[] nums2) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums2[i]) {
                System.out.println("wrong");
                return;
            }
        }
        System.out.println("correct");
    }



    /*@org.junit.Test
    public void testPartition() {
        QuickSort qs=new QuickSort();
        int number = 100000000;
        int[] nums = new int[number];
        int[] nums2 = new int[number];
        for (int i = 0; i < number; i++) {
            int ran = (int) (Math.random() * 1000000);
            nums[i] = nums2[i] = ran;
        }

        long start = System.currentTimeMillis();
        qs.partition(nums, 0, number - 1);
        long end = System.currentTimeMillis();
        System.out.println("partition:" + (end - start));

        start = System.currentTimeMillis();
        partition2(nums2, 0, number - 1);
        end = System.currentTimeMillis();
        System.out.println("partition2:" + (end - start));
    }*/
}
