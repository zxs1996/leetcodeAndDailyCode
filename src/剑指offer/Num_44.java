package 剑指offer;

import org.junit.Test;

import javax.lang.model.util.ElementScanner6;

/**
 * @author zxs666
 * @date 2021/3/12 20:28
 */
public class Num_44 {
    public int findNthDigit(int n) {
        int digit = 1; //数字位数(例如三位数digit=3)
        long start = 1; //digit位数的第一个数字
        long count = 9; //所有digit位数所占的位数
        while (n > count) {//1.确定n所在的数字的位数digit
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        //2. 确定n所在的数字num
        //此时n的值是相对于start的位置
        long num = start + (n - 1) / digit; //n-1是因为start是第0个数字
        //3. 确定n是num的第几位
        //这里引入s和c方便理解
        String s = Long.toString(num);
        char c = s.charAt((n - 1) % digit); //n-1是因为String下标从0开始
        return c - '0';
    }

    @Test
    public void test() {
        int n = 698;
        System.out.println("标准：" + findNthDigit(n));

    }

}
