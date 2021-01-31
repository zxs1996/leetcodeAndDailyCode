package 力扣_401_500;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/10/30 17:33
 * :思路，遍历字符串，对于每个字符，如果这个字符比它前面的字符要小，那么删除前面那个字符，继续往前比较
 * 可以通过栈来实现：
 * 每次需要比较的字符都在栈顶，如果当前字符比栈顶字符小，那么栈顶字符出栈，k-1
 * 一直到找不到比当前字符更大的栈顶字符，将当前字符入栈
 *
 */
public class Num_402 {

    @Test
    public void test() {
        int n = 10;
        char[] arr = new char[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = (char) (random.nextInt(10) + '0');
        System.out.println(new String(arr));
        String res = removeKdigits("10200", 1);
        System.out.println(res);
    }

    @Test
    public void test2() {
        String res = removeKdigits2("10200", 1);
        System.out.println(res);
    }

    //使用数组切割实现
    public String removeKdigits(String num, int k) {

        while (k > 0 && num.length() > 0) {
            int i = 0;
            //从前到后，如果num[i]>num[i+1]，那么去除i这个位置的字符
            i = 0;
            while (i < num.length() - 1 && num.charAt(i) <= num.charAt(i + 1))
                i++;
            //重新拼接num
            num = num.substring(0, i) + num.substring(i + 1);
            k--;
            //每次处理之后，去除空格
            i = 0;
            while (i < num.length() && num.charAt(i) == '0')
                i++;
            num = num.substring(i);
        }


        if (num == null || num.length() == 0)
            return "0";
        return num;

    }

    //使用栈实现
    public String removeKdigits2(String num, int k) {
        if (k <= 0)
            return num;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            //循环处理
            //k大于0，栈不为空，并且当前元素比栈顶元素还小，那么弹出栈顶元素
            while (k > 0 && stack.size() != 0 && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            //将当前元素入栈
            stack.push(num.charAt(i));
        }
        //如果元素是顺序递增的，比如123456789,在上面的循环里面，每一个元素都不会被去除
        //在这里去除多余的元素
        while (k-- > 0)
            stack.pop();

        //出栈对栈元素逆序放到一个字符数组里
        char[] arr = new char[stack.size()];
        int index = arr.length - 1;
        while (stack.size() > 0)
            arr[index--] = stack.pop();
        index = 0;
        while (index < arr.length && arr[index] == '0') index++;
        return index == arr.length ? "0" : new String(arr).substring(index);
    }
}
