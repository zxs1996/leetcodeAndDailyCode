package 力扣_301_400;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/12/21 20:09
 */
public class Num_394 {
    public String decodeString(String s) {
        Stack<String> charStack = new Stack();
        Stack<Integer> intStack = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            //如果是数字，那么入栈
            if (arr[i] >= '0' && arr[i] <= '9') {
                int j = i + 1;
                while (j < arr.length && arr[j] >= '0' && arr[j] <= '9')
                    j++;
                int num = Integer.valueOf(s.substring(i, j));
                intStack.push(num);
                i = j - 1;
            } else {
                //如果是右括号，那么取出一个左括号匹配
                if (arr[i] == ']') {
                    List<String> list = new LinkedList<>();
                    String tmp;
                    while (!(tmp = charStack.pop()).equals("["))
                        list.add(0, tmp);
                    StringBuffer sb = new StringBuffer();
                    list.stream().forEach(str -> sb.append(str));

                    StringBuffer inputStr = new StringBuffer(sb);
                    int num = intStack.pop();
                    for (int j = 1; j < num; j++)
                        inputStr.append(sb);
                    //如果前面没有数字了，那么直接放入结果res
                    if (intStack.isEmpty())
                        res.append(inputStr);
                    else
                        charStack.push(inputStr.toString());

                }
                //否则push
                else {
                    if(intStack.isEmpty())
                        res.append(arr[i]);
                    else
                        charStack.push(arr[i] + "");
                }
            }
        }

        charStack.stream().forEach(str -> res.append(str));

        return res.toString();
    }


    @Test
    public void test1() {
        String s = "abc3[cd]xyz";
        System.out.println(decodeString(s));
    }
}
