package 力扣_201_300;

import org.junit.Test;

import java.util.*;

public class Num_239 {
    @Test
    public void test() {
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(2, 3);
        map.put(1, 4);
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println(key);
        }
    }


    /**
     * 暴力法，时间复杂度会超
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int start = 0, end = k;
        //先找第一个窗口里面的max值
        int max = nums[0];
        for (int i = 0; i < end; i++)
            max = Math.max(max, nums[i]);
        res[0] = max;
        start++;
        end++;
        for (int i = 1; i < res.length; i++, start++, end++) {
            //如果新增的值小于之前窗口最大值，并且该值目前还在窗口内，那么直接赋值
            if (nums[end - 1] < max && nums[start - 1] < max) {
                res[i] = max;
                System.out.println("check");
                continue;
            }
            max = nums[start];
            for (int j = start; j < end; j++)
                max = Math.max(max, nums[j]);
            res[i] = max;
        }
        return res;
    }


    /**
     * 使用栈记录当前滑动窗口的数据，注意栈里面存放下标，不是值
     * 比如k=3，窗口值为1 2 3时，我们只有存3的下标就行。因为1 2比3小，并且比3先被移出滑动窗口
     * 比如k=3，窗口值为2 3 1，这是栈从底到上应该是3 1，需要把1保留下来，因为有可能3移出去了，后面的窗口最大值是1
     * 队一定是一个严格递减的队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        //利用前k个元素初始化队列
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i])
                queue.removeLast();
            queue.addLast(i);
        }
        //第一个值
        res[0] = nums[queue.getFirst()];

        //往右移动滑动窗口，最开始滑动窗口为[0,k-1]
        //这里我们设置left左边界从1开始，右边界为left+k-1
        for (int left = 1; left + k <= n; left++) {
            int right = left + k - 1;
            //如果当前队头元素的索引小于了left，表示队头出了滑动窗口
            if (queue.getFirst() < left)
                queue.removeFirst();
            //循环判断，当前要加入的元素是否大于等于队尾元素，如果大于那么移除队尾
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[right])
                queue.removeLast();
            queue.addLast(right);
            res[left] = nums[queue.getFirst()];
        }
        return res;
    }


}
