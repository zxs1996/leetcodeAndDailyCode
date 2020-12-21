package 排序算法.heap;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/10/20 19:12
 * <p>
 * 关于堆排序当中父子下标的问题，一定要建立在从下标从1开始，如果下标从0开始，那么就不成立，所以这里我们使用下标1开始，每次把数组开大一个
 */
public class MyPriorityQueue<E> extends AbstractQueue {


    private final int DEFAULT_SIZE = 10;


    //数组长度
    private int size;

    //当前队列最后一个元素的下标，如果为0，那么表示空，数据从下标1开始存储，方便调整堆
    private int currentCapacity = 0;
    private E[] arr;

    private Comparator<E> comparator;

    public MyPriorityQueue(int size, Comparator comparator) {
        this.size = size;
        arr = (E[]) new Object[size + 1];
        this.comparator = comparator;
    }

    public MyPriorityQueue(Comparator comparator) {
        arr = (E[]) new Object[DEFAULT_SIZE + 1];
        this.comparator = comparator;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return currentCapacity;
    }


    @Override
    public boolean offer(Object o) {
        //如果满了，那么需要扩容
        if (currentCapacity == size - 1) {
            arr = Arrays.copyOf(arr, arr.length * 2);
            size = arr.length;
        }

        //放入队列
        arr[++currentCapacity] = (E) o;

        //调堆
        //当存储的元素超过两个之后才开始调整堆，向上调堆，从最后一个非叶节点向上
        if (currentCapacity > 1)
            minHeapUp(arr, currentCapacity / 2, currentCapacity + 1);
        return true;

    }

    public void show() {
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public Object poll() {
        //如果空间为1，那么返回null
        if (currentCapacity == 0)
            return null;
        Object res = arr[1];
        //将最后一个元素放到第一个位置，并调堆
        arr[1] = arr[currentCapacity--];
        //向下调堆，从根节点向下
        minHeapDown(arr, 1, currentCapacity + 1);
        return res;
    }

    @Override
    public Object peek() {
        return currentCapacity == 0 ? null : arr[1];
    }


    //调堆，从i往上调整
    private void minHeapUp(E[] a, int i, int size) {
        //如果调整到0，那么返回，0是不存储数据的
        if (i == 0)
            return;
        //System.out.println("get in");
        int lChild = i * 2;
        int rChild = i * 2 + 1;
        int min = i;
        //如果左孩子存在且左孩子比min小，那么设置min为lChild的下标
        if (lChild < size && comparator.compare(a[lChild], a[min]) < 0)
            min = lChild;
        //如果右孩子存在且左孩子比min小，那么设置min为rChild的下标
        if (rChild < size && comparator.compare(a[rChild], a[min]) < 0)
            min = rChild;

        //如果min被修改了，说明左右孩子有一个是比它小的，那么交换，然后往下继续调整孩子节点
        if (min != i) {
            E temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            //如果i和它的儿子节点交换了，那么需要继续往上调整
            minHeapUp(a, i / 2, size);
        }
    }

    //调堆，从i往下调整
    private void minHeapDown(E[] a, int i, int size) {
        //如果调整到0，那么返回，0是不存储数据的
        if (i == 0)
            return;
        //System.out.println("get in");
        int lChild = i * 2;
        int rChild = i * 2 + 1;
        int min = i;
        //如果左孩子存在且左孩子比min小，那么设置min为lChild的下标
        if (lChild < size && comparator.compare(a[lChild], a[min]) < 0)
            min = lChild;
        //如果右孩子存在且左孩子比min小，那么设置min为rChild的下标
        if (rChild < size && comparator.compare(a[rChild], a[min]) < 0)
            min = rChild;

        //如果min被修改了，说明左右孩子有一个是比它小的，那么交换，然后往下继续调整孩子节点
        if (min != i) {
            E temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            //如果i和它的儿子节点交换了，那么需要继续往下调整
            minHeapDown(a, min, size);
        }
    }


}
