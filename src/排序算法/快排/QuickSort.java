package 排序算法.快排;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zxs666
 * @date 2021/3/25 0:33
 */
public class QuickSort {

    @Test
    public void test(){
        int N=10;
        int[] arr=new int[N];
        int[] arr2=new int[N];
        for(int i=0;i<10;i++)
            arr[i]=arr2[i]=new Random().nextInt(1000);
        Arrays.sort(arr);
        quickSort(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }


    public void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);

    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int random = new Random().nextInt(right - left+1) + left;
        swap(arr, right, random);
        int key = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < key) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, right);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
