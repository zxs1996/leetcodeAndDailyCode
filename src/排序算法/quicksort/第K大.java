package 排序算法.quicksort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zxs666
 * @date 2021/4/4 22:33
 */
public class 第K大 {

    @Test
    public void test() {
        int N=10;
        int[]arr =new int[N];
        Random random=new Random();
        for(int i=0;i<N;i++)
            arr[i]=random.nextInt(100);
        System.out.println(findK(arr,5));
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public int findK(int[] arr, int k) {
        return find(arr, 0, arr.length-1, arr.length - k);

    }

    public int find(int[] arr, int start, int end, int K) {
        int partition = partition(arr, start, end);
        if (partition == K) {
            return arr[partition];
        } else if (partition > K)
            return find(arr, start, partition - 1, K);
        else
            return find(arr, partition + 1, end, K);

    }

    public int partition(int[] arr, int start, int end) {
        int i = start - 1;
        int random = new Random().nextInt(end - start + 1) + start;
        swap(arr, random, end);
        int key = arr[end];
        for (int j = start; j < end; j++) {
            if (arr[j] < key) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, end);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
