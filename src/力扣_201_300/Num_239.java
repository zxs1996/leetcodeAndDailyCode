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


    ArrayDeque<Integer> queue = new ArrayDeque();
    int[] nums;

    //先清理前一个,
    public void cleanQueue(int i, int k) {
        //移除不在窗口里面的元素,如果最大元素下标等于i-k说明，这个最大元素已经是上一个元素了。
        if (!queue.isEmpty() && queue.getFirst() == i - k)
            queue.removeFirst();
        //移除所有比当前元素小的元素的索引，从后往前移除。因为当前元素一定是在前面元素的后面，移除前面的元素不影响最大值
        while (!queue.isEmpty() && nums[i] > nums[queue.getLast()])
            queue.removeLast();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        this.nums = nums;
        int maxIndex = 0;
        //先初始化第一个队列
        for (int i = 0; i < k; i++) {
            //移除不在区间内的元素
            cleanQueue(i, k);
            queue.addLast(i);
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        //第一个元素
        res[0] = nums[maxIndex];
        for (int i = k; i < nums.length; i++) {
            //清理队列
            cleanQueue(i, k);
            //将当前下标放入队列
            queue.add(i);
            res[i - k + 1] = nums[queue.getFirst()];
        }
        return res;
    }
}
