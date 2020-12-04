package num_more_1000;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/12/2 21:36
 *
 * 逆序数问题，使用栈来解决
 */
public class Num_1673 {


    public static void main(String[] args) {

        int[] nums = {71,18,52,29,55,73,24,42,66,8,80,2};
        int[] res = new Num_1673().mostCompetitive(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    public int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer> stack = new Stack<>();
        int removeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && removeCount < nums.length - k) {
                stack.pop();
                removeCount++;
            }
            stack.push(nums[i]);
        }
        int[] res = new int[k];

        for (int i = 0; i < k; i++)
            res[i] = stack.get(i);

        return res;
    }


    //找逆序数
    public int findNixu(Stack<Integer> stack, int start) {
        for (int i = start; i < stack.size() - 1; i++) {
            if (stack.get(i) > stack.get(i + 1))
                return i;
        }
        return stack.size();
    }
}
