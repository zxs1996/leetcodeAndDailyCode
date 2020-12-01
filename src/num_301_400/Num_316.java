package num_301_400;

import org.junit.Test;

import javax.xml.transform.Source;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/10/30 17:02
 * 本题思路跟402异曲同工:
 * 先使用一个map记录每个字符出现的次数k，那么这个字符需要删除k-1次
 * 创建一个栈。
 * 遍历字符串如果当前字符比栈顶字符小，并且栈顶字符当前出现次数大于1，那么栈顶字符出栈，栈顶字符计数-1
 * 最后如果栈里面剩的字符大于字符种数，那么有选择的取前n个，n表示字符的种类
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
        HashMap<Character, Integer> map = new HashMap<>();
        //记录每个字符出现的次数
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        Stack<Character> stack = new Stack<>();
        char c, stackTopChar;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            //每次这个元素都要-1
            map.put(c, map.get(c) - 1);
            if (stack.contains(c))
                continue;
            //栈不为空，栈顶元素大于当前元素c,且栈顶元素后面还会出现
            while (stack.size() > 0 && (stackTopChar = stack.peek()) > c && map.get(stackTopChar) >= 1)
                stack.pop();
            stack.push(c);
        }
        //出现字符的种数，最后的结果只用返回这么多个字符
        int charCount = map.size();
        //去除后面多余的字符
        while (stack.size() > charCount)
            stack.pop();
        StringBuffer sb = new StringBuffer("");
        stack.stream().forEach((cc) -> {
            sb.append(cc);
        });
        return sb.toString();
    }
}
