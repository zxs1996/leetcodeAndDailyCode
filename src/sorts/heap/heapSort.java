package sorts.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zxs666
 * @date 2020/10/20 18:44
 * 为了处理好父子节点的下标对应关系，我们从下标为1开始存数据，下标为0不存数据
 * 将数据从下标1——N存储，然后对1——N进行堆排序
 */
public class heapSort {
    @Test
    public void test() {
        int N = 10;
        int[] a = new int[N + 1];
        for (int i = 1; i <= N; i++)
            a[i] = (int) (Math.random() * 100);
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    //堆排序
    public void heapSort(int[] a) {
        //先建堆
        buildMinHeapint(a);
        //选择当前根元素和最后一个元素交换(currentSize表示最后一个元素的下标，每次currentSize--），堆根元素下标为1
        for (int currentSize = a.length - 1; currentSize >= 2; currentSize--) {
            //先调堆
            minHeapIfy(a, 1, currentSize);
            //将堆顶和最后一个元素交换位置
            int temp = a[1];
            a[1] = a[currentSize];
            a[currentSize] = temp;
        }
        //这时候排出来的是逆序的，并且第一个元素是0，如果想从小到大顺序，那么可以翻转一下。
    }


    //调整以i为根节点的小根堆，假设i的子节点已经调整好了,
    // 这里接收一个当前数组的可用长度size，用于堆排序过程中动态表示堆长度
    public void minHeapIfy(int[] a, int i, int size) {
        //注意这里下标的处理，因为我们是从下标1开始存数据的
        int lChild = i * 2;
        int rChild = i * 2 + 1;
        int min = i;
        //如果左孩子存在且左孩子比min小，那么设置min为lChild的下标
        if (lChild < size && a[lChild] < a[min])
            min = lChild;
        //如果右孩子存在且左孩子比min小，那么设置min为rChild的下标
        if (rChild < size && a[rChild] < a[min])
            min = rChild;


        //如果min被修改了，说明左右孩子有一个是比它小的，那么交换，然后往下继续调整孩子节点
        if (min != i) {
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            minHeapIfy(a, min, size);
        }
    }


    //建堆，将一个无序的数组建成一个小根堆
    public void buildMinHeapint(int[] a) {
        //从最后一个非叶节点开始调整,一直调整到根节点
        //注意下标的处理，这里是从1开始存的，假设存10个元素，最后一个元素的下标是a.length-1
        //只用处理到下标为1就好
        for (int i = (a.length - 1) / 2; i >= 1; i--)
            minHeapIfy(a, i, a.length);
    }

}
