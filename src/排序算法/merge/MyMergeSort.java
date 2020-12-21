package 排序算法.merge;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/10/20 17:17
 */
public class MyMergeSort {


    @Test
    public void test1() {
        int N = 10;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = (int) (Math.random() * 100);
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int[] a){
        mergeSort(a,0,a.length-1);
    }

    //递归调用归并排序
    private void mergeSort(int[] a, int left, int right) {
        //递归结束条件
        if (left >= right)
            return;
        int mid = (right + left) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }


    //两个数组合并
    private void merge(int[] a, int left, int mid, int right) {
        int l1 = mid - left + 1;//把中间那个数划给左边数组
        int l2 = right - mid;
        //多开一个，用作哨兵，存值为Integer.MAX_VALUE
        int[] arr1 = new int[l1 + 1];
        int[] arr2 = new int[l2 + 1];
        for (int i = 0; i < l1; i++)
            arr1[i] = a[left + i];
        for (int i = 0; i < l2; i++)
            arr2[i] = a[mid + i + 1];
        arr1[l1] = arr2[l2] = Integer.MAX_VALUE;

        int i = 0, j = 0, index = left;
        for (; i != l1 || j != l2; ) {
            if (arr1[i] <= arr2[j])
                a[index++] = arr1[i++];
            else
                a[index++] = arr2[j++];
        }
    }
}
