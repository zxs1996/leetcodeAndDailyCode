package 排序算法.quicksort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: zhw_98
 * @Date: 2020/11/11 14:10
 */
public class ZHWSort {
    //交换元素
    public static void swap(int nums[],int i, int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static  int partition(int[] nums,int low,int high){//对数组A下标从first到last中选一个主元，确定其位置，左边小于，右边大于。
        int pivot=nums[low];//先定义区间数组第一个元素为主元
//        int pivot = getPivot(nums,low,high);
        int i=low;   //定义最低的索引low是first+1。比主元大一位
        int j=high;     //定义最高的索引high是last
        while(i!=j){   //当low小于high的位置时，执行以下循环
            while(nums[j]>pivot&&i<j){//当high的索引上的值比主元大时，且索引大于low时
                j--;                      //寻找比主元小的值的位置索引
            }
            while(nums[i]<=pivot&&i<j){//当low的索引上的值比主元小时，索引小于high时
                i++;                       //寻找比主元大的值的位置索引。
            }
            if(i<j){   //交换low和high的值
                swap(nums,i,j);
            }
        }
        nums[low]=nums[j];
        nums[j]=pivot;
        return j;
    }


    public static int[] QuickSort(int nums[],int low,int high){
        if(low<high){
            int q = partition(nums,low,high);
            QuickSort(nums,low,q-1);
            QuickSort(nums,q+1,high);
        }
        return nums;
    }


    @Test
    public void test(){
        int[] nums = new int[1000000];
        for (int i=0; i<1000000;i++){
            nums[i] = new Random().nextInt(100000);
//              System.out.print(nums[i]+" ");
        }
        long startTime = System.currentTimeMillis();
        QuickSort(nums,0,nums.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("===============================================================================");
//        for (int num:nums){
//            System.out.print(num+" ");
//        }
        long time = endTime - startTime ;
        System.out.println("QickSort()1:1000000数组排序时间："+time);
    }
    @Test
    public  void test2(){
        int[] nums = new int[1000000];
        for (int i=0; i<1000000;i++){
            nums[i] = new Random().nextInt(10000000);
//              System.out.print(nums[i]+" ");
        }
        long startTime2 = System.currentTimeMillis();
//        QuickSort2(nums,0,nums.length-1);
        Arrays.sort(nums);
        long endTime2 = System.currentTimeMillis();
        long time2 = endTime2 - startTime2 ;
        System.out.println("ArraySort:1000000数组排序时间："+time2);
    }

}