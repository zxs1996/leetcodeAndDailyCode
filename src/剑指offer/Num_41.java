package 剑指offer;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zxs666
 * @date 2021/4/1 23:32
 */
public class Num_41 {

    class MedianFinder {

        //pq1放较小那一半里面的较大的
        Queue<Integer> pq1;
        //pq2放较大那一半里较小的
        Queue<Integer> pq2;

        int sum = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            //大根堆
            pq1 = new PriorityQueue<>((i1, i2) -> i2 - i1);
            //小根堆
            pq2 = new PriorityQueue<>();
        }

        public void addNum(int num) {

            //直接放入pq1
            pq1.add(num);

            //如果两个集合相差超过2,pq1出去一个给pq2
            if (pq1.size() > pq2.size() + 1) {
                pq2.add(pq1.poll());
            }
            //如果pq的堆顶大于pq2的堆顶，那么交换他们俩
            else if (!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek() > pq2.peek()) {
                int temp1 = pq1.poll();
                int temp2 = pq2.poll();
                pq1.add(temp2);
                pq2.add(temp1);
            }

            sum++;

        }

        public double findMedian() {
            if ((sum & 1) == 1) {
                return pq1.peek();
            } else return (pq1.peek() + pq2.peek()) / 2.0;
        }
    }
}
