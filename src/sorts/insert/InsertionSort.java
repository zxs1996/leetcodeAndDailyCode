package sorts.insert;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSort {


    @Test
    public void test(){
        int []nums=new int[10];
        for(int i=0;i<10;i++)
            nums[i]=(int) (Math.random()*1000);
        System.out.println(Arrays.toString(nums));

        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }




    public void insertSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int key=nums[i];
            int j=i-1;
            for(;j>=0&&nums[j]>key;j--)
                nums[j+1]=nums[j];
            nums[j+1]=key;
        }
    }
}
