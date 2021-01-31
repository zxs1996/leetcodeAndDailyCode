package 力扣_401_500;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/11/15 23:47
 */
public class Num_402_2 {

    @Test
    public void test(){
        String num="1432219";
        String res=removeKdigits(num,3);
        System.out.println(res);
    }
    public String removeKdigits(String num, int k) {
        if (num.length() == 0)
            return "0";
        Stack<Integer> stack = new Stack();
        char[] arr = num.toCharArray();
        stack.push(Integer.valueOf(arr[0] + ""));
        int i = 1;
        while (i<arr.length) {
            int cur = Integer.valueOf(arr[i++] + "");

            while (k > 0 && !stack.isEmpty() && stack.peek() > cur) {
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        while(k-->0)
            stack.pop();
        Object[] intArr=stack.toArray();
        StringBuilder sb=new StringBuilder();
        for(Object temp:intArr)
            sb.append(temp);
         i=0;
        while(i<sb.length()&&sb.charAt(i)=='0')
            i++;
        String res=sb.substring(i);
        return res.length()==0?"0":res;

    }
}
