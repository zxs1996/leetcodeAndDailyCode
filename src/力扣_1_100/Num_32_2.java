package 力扣_1_100;

import java.util.Stack;

/**
 * @author zxs666
 * @date 2021/2/6 15:19
 */
public class Num_32_2 {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int res = 0;
        //dp[i]表示以i结尾的字符的最长括号的匹配长度
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {

            //如果是右括号，那么处理，左括号不用处理。
            if (arr[i] == ')') {
                //如果前一个符号是左括号，那么直接匹配上
                if (arr[i - 1] == '(')
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                    //如果前一个是右括号
                else {
                    //前一个匹配长度不为0,如果前一个为0，那么本个也一定为0
                    if (dp[i - 1] != 0) {
                        //前一个匹配项的匹配的前一个下标
                        int leftIndex = i - 1 - dp[i - 1];
                        if (leftIndex >= 0 && arr[leftIndex] == '(') {
                            dp[i] = dp[i - 1] + 2;
                            dp[i] += leftIndex > 0 ? dp[leftIndex - 1] : 0;
                        }

                    }
                }
                res = Math.max(res, dp[i]);

            }

        }
        return res;
    }

    /**
     * 栈实现
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        //栈底放的是最后一个没有匹配的')'下标,栈底永远都是最后一个未匹配的右括号的下标
        //初始放入-1占位
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果是左括号，直接push
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            //如果是右括号
            else {
                //出栈一个，无论是左括号或者右括号都出栈，栈里最多只会存在一个右括号，因为如果右括号多余，一定是匹配不上的
                stack.pop();
                //如果栈空，说明前一个出的是右括号，那么把当前右括号放进去
                if (stack.isEmpty())
                    stack.push(i);
                //如果不空，说明是左括号，更新res
                 else
                    res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
