package 排序算法.heap;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author zxs666
 * @date 2020/10/20 19:34
 */
public class TestQueue {

    @Test
    public void test() {

        int a[] = new int[]{1, 2, 34};

        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>((o1, o2) -> (Integer) o1 - (Integer) o2);
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            System.out.print(num + "  ");
            queue.offer(num);
        }
        System.out.println();

        for (; queue.size()>0; )
            System.out.print(queue.poll()+"  ");
    }


    @Test
    public void test2() {

        Comparator<Integer> comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o1 - (int) o2;
            }
        };

        System.out.println(comparator.compare(1,2));
    }
}
