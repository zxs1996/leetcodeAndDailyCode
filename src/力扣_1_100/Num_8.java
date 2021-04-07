package 力扣_1_100;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2021/2/20 21:00
 */
public class Num_8 {

    @Test
    public void test(){
        System.out.println(myAtoi("  -42"));
    }
    public int myAtoi(String s) {
        s = s.trim();
        long res = 0;
        int flag = 1;
        if (s.length() == 0)
            return 0;
        if (s.charAt(0) == '-') {
            flag = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            flag = 1;
            s = s.substring(1);
        }
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                res *= 10;
                res += Integer.parseInt(c + "");
            } else
                break;
            if (res*flag  > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (res*flag < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        res*=flag;
        if (res  > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) res ;
    }
}
