package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author zxs666
 * @date 2021/3/29 15:09
 * <p>
 * //使用双向队列
 * 队头永远放最大的元素，当窗口滑动的时候，判断队头元素是否等于移除元素，如果是的话，那么移除队头
 * 每个元素进来的时候，循环判断队尾，直到队尾元素大于当前元素，这样能保证队列是非递增的。
 */
public class Num_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {

            
        if (nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> queue = new ArrayDeque();
        int res[] = new int[nums.length - k + 1];
        //先初始化队列
        for (int i = 0; i < k; i++) {
            //如果队尾元素小于当前元素，那么一直remove
            while (!queue.isEmpty() && queue.getLast() < nums[i])
                queue.removeLast();
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            if (queue.peek() == nums[i - k])
                queue.removeFirst();
            while (!queue.isEmpty() && queue.getLast() < nums[i])
                queue.poll();
            queue.add(nums[i]);
            res[i - k + 1] = queue.peek();
        }

        return res;
    }
}
