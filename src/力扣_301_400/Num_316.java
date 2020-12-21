package 力扣_301_400;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/10/30 17:02
 * 本题思路跟402异曲同工:
 * 先使用一个map记录每个字符出现的次数k，那么这个字符需要删除k-1次
 * 创建一个栈。
 * 遍历字符串如果当前字符比栈顶字符小，并且栈顶字符当前出现次数大于1，那么栈顶字符出栈，栈顶字符计数-1
 */
public class Num_316 {

    @Test
    public void test() {
        HashMap<Character, Integer> map = new HashMap<>();
        String s = "cbacdcbc";
        String res = removeDuplicateLetters(s);
        System.out.println("res:" + res);
    }


    public String removeDuplicateLetters(String s) {
        //记录每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            //计数-1
            map.put(c, map.get(c) - 1);
            //如果这个元素已经
            if (set.contains(c))
                continue;
            //如果栈顶元素栈顶元素大于c，并且栈顶元素后面还会出现，那么栈顶元素出栈
            while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > 0) {
                set.remove(stack.pop());
            }
            //当前元素入栈
            stack.push(c);
            set.add(c);
        }
        StringBuffer sb = new StringBuffer();
        stack.stream().forEach(ch -> sb.append(ch));
        return sb.toString();
    }


}
