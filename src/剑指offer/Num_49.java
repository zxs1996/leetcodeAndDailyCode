package 剑指offer;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author zxs666
 * @date 2021/3/13 12:27
 */
public class Num_49 {

    @Test
    public void test() {
        int a=11;
        int b=12;
        int c=a^b;
        System.out.println(c);
        System.out.println(c^a);

        int res = nthUglyNumber(1024);
        System.out.println();
        System.out.println("res:" + res);
    }

    public int nthUglyNumber(int n) {

        int[] f = new int[n + 2];
            f[1] = 1;
        int index_2 = 1;
        int index_3 = 1;
        int index_5 = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int number1 = 2 * f[index_2];
            int number2 = 3 * f[index_3];
            int number3 = 5 * f[index_5];;
            number1 = number1 > cur ? number1 : Integer.MAX_VALUE;
            number2 = number2 > cur ? number2 : Integer.MAX_VALUE;
            number3 = number3 > cur ? number3 : Integer.MAX_VALUE;

            int min = Math.min(number1, Math.min(number2, number3));
            cur = min;
            if (min == number1)
                index_2++;

            if (min == number2)
                index_3++;

            if (min == number3)
                index_5++;
            f[i] = cur;
        }

        return f[n];

    }
}
