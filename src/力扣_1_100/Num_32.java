package 力扣_1_100;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/12/17 15:31
 */
public class Num_32 {
    @Test
    public void test() {
        String str = "()(())";
        System.out.println(longestValidParentheses(str));
    }

    /**
     * 动态规划，dp[i]表示以下标i结尾的字符串的有效括号匹配长度
     * s[i]如果是(,那么不操作
     * s[i]如果是),那么有两种情况
     * --s[i-1]=(,dp[i]=dp[i-2]+2;
     * --s[i-1]=),去找dp[i-1]有效长度(比如dp[i-1]等于4，那么我去找i-4那个位置的字符）
     * 的前一个符号s[k]是不是(,如果是的话，那么规约到dp[k-1]+(i-k+1)
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];//dp[i]表示以i结尾的有效括号的长度
        int res = 0;
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                //如果前一个是左括号，那么匹配上
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                }
                //前一个是右括号,去找他的匹配长度,看最前面有没有左括号
                else {
                    //如果前一个有效长度不为0，
                    if (dp[i - 1] != 0) {
                        //并且它没有覆盖前面全部长度，并且前面那个符号为'('，那么+2；
                        int leftIndex = i - 1 - dp[i - 1];
                        if (leftIndex >= 0 && s.charAt(leftIndex) == '(')
                            dp[i] = leftIndex > 0 ? i - leftIndex + 1 + dp[leftIndex - 1] : i - leftIndex + 1;
                    }

                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    /**
     * 用栈来实现
     *
     * @param s
     * @return
     */
    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        //栈底元素，表示最后一个未匹配的')'下标，初始放入一个-1
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                //出栈一个
                stack.pop();
                //如果出栈后为空，那么说明是-1出栈了，即当前这个i的这个符号未能匹配到，将这个i push进去
                if (stack.size() == 0) {
                    stack.push(i);
                }
                //否则，说明这个左括号匹配到了，那么它匹配的有效长度为i - stack.peek()，选择一个较大值
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }




}
