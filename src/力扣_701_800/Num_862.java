package 力扣_701_800;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zxs666
 * @date 2021/4/4 22:44
 *
 * 核心思想
 */
public class Num_862 {
    public int shortestSubarray(int[] A, int K) {
        long[] sum = new long[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
            if (A[i] >= K) return 1;
        }//得到前缀和数组
        int res = Integer.MAX_VALUE;


        /**
         * 在前缀和的基础上优化，
         * 因为前缀和，比如当i=5的时候，我们要考虑它前面的 1 2 3 4。但是有可能有些数据是没有意义的
         * 比如 10 -5 20
         * 前缀和分别为10 5 25
         *
         * 对于25的时候，我们会考虑sum[2]-sum[1]和sum[2]-sum[0],
         * 因为 1>0 并且sum[1]<sum[0]，那么0 就没有必要了，因为即使我们使用了sum[2]-sum[0]<sum[2]-sum[1],，并且还更长
         *
         */


        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < sum.length; i++) {
            //就像队列里面放的是10 5 ，那么10 是没有意义的
            //当前sum[i]小于前面的sum[队列最后一个],那么队尾移除。这个单调队列里面是单调递增的
            while (!queue.isEmpty() && sum[i] <= sum[queue.getLast()]) queue.removeLast();
            //从前往后看，当sum[i]-sum[队列头的]>=K，更新res，并且让队头出栈。
            while (!queue.isEmpty() && sum[i] - sum[queue.peek()] >= K) res = Math.min(res, i - queue.poll());
            queue.add(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
