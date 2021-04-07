package 力扣_1_100;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2021/2/20 22:23
 */
public class Num_84 {
    /**
     * 暴力算法，时间复杂度 o(N²)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i])
                j--;
            int k = i + 1;
            while (k < n && heights[k] >= heights[i])
                k++;
            res = Math.max(res, heights[i] * (k - j - 1));
        }
        return res;

    }


    //利用栈算法
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        //放入-1，标志
        stack.push(-1);
        //第一轮，先扫描数组
        for (int i = 0; i < heights.length; i++) {
            //如果栈顶的高度大于当前高度，计算栈顶下标位置矩形面积,一直循环
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i])
                //注意这里的顺序很重要，先pop，在peek()，这里为什么要用peek,比如 2 1  2这种情况，第一个2会被弹出来，那我们只能以它的前一个-1作为依据。
                res = Math.max(res, heights[stack.pop()]*(i-stack.peek()-1));
            stack.push(i);

        }

        //这个时候已经扫描过一轮数组，栈里面剩下的元素下标对应的高度应该是递增的，一个一个计算对应矩形面积即可
        while (stack.peek() != -1) {
            //这里顺序很重要，先pop，在peek，跟上面一样。不过这里的有边界是heights.length-1
            res = Math.max(res, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return res;
    }

    @Test
    public void test1(){

        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(heights));
    }
}
