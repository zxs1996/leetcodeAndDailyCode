package 双周赛.dc_43;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author zxs666
 * @date 2021/1/9 23:48
 */
public class Num_5634 {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        char ch1 = 'a', ch2 = 'b';
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        if (y > x) {
            ch1 = 'b';
            ch2 = 'a';
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch2) {
                if (!stack.isEmpty() && stack.peek() == ch1) {
                    stack.pop();
                    res += max;
                } else
                    stack.push(s.charAt(i));
            } else if (s.charAt(i) == ch1) {
                stack.push(ch1);
            } else {
                List<Character> list = stack.stream().collect(Collectors.toList());
                stack.clear();
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == ch1 && !stack.isEmpty() && stack.peek() == ch2) {
                        stack.pop();
                        res += min;
                    }
                    stack.push(list.get(j));
                }
                stack.clear();
            }
        }
        List<Character> list = stack.stream().collect(Collectors.toList());
        stack.clear();
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == ch1 && !stack.isEmpty() && stack.peek() == ch2) {
                stack.pop();
                res += min;
            }
            stack.push(list.get(j));
        }
        stack.clear();

        return res;

    }
}
