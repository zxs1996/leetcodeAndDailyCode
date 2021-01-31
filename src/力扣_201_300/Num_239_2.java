package 力扣_201_300;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.*;

/**
 * @author zxs666
 * @date 2021/1/2 10:39
 * 思路：用一个栈来记录当前窗口内的值,注意可以删除一些无用的值
 * 比如k=3， 当前窗口元素为1 2 3 我们只用把3放进去就好，因为1 2比3小，并且比3先被淘汰。所以无论如何也不会用到1和2
 * 但是有些值不能删
 * 比如k=3,窗口值为 2 3 1 那么2可以从栈中删掉，但是1不行，因为3会比1先离开滑动窗口，需要把1保留下来，有可能后面没有比1更大的数了
 */
public class Num_239_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        //初始化栈
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i])
                queue.removeLast();
            queue.addLast(i);
        }
//        System.out.println(queue);
        //第一个数
        res[0] = nums[queue.getFirst()];

        //i表示的是左边界
        for (int left = 1; left + k <= n; left++) {
            int right = left + k - 1;
            if (queue.getFirst() < left)
                queue.removeFirst();
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[right])
                queue.removeLast();
            queue.addLast(right);
            res[left] = nums[queue.getFirst()];
//            System.out.println(left+"  "+queue);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test2() throws InterruptedException {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new LinkedList<>();
        int N = 10000000;

        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
            list.add(i + 1);
        }
        System.out.println("put ok");
        Thread.sleep(5000);
        System.out.println("wake");
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            deque.removeFirst();
        long end = System.currentTimeMillis();
        System.out.println("双端队列：" + (end - start));


        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
            list.remove(0);
        end = System.currentTimeMillis();
        System.out.println("链表：" + (end - start));

        System.out.println(deque.size());
        System.out.println(list.size());

    }
}
