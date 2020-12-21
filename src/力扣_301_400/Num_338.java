package 力扣_301_400;

import org.junit.Test;

import java.util.Arrays;

public class Num_338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        Arrays.fill(res, 0);
        for (int i = 0; i <= num; i++) {
            char[] chars = Integer.toBinaryString(i).toCharArray();
            for (char c : chars) {
                if (c == '1')
                    res[i]++;
            }
        }
        return res;
    }

    @Test
    public void demo1() {
        int[] res = countBits2(20);
        int[] res2 = countBits(20);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i] == res2[i]);
    }

    public int[] countBits2(int num) {
        if (num == 0)
            return new int[]{0};
        if (num == 1)
            return new int[]{0, 1};
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        int start = 1;
        for (int i = 2; i <= num; i++) {
            if (i == start * 2) {
                res[i] = 1;
                start = i;
            } else {
                //当前的基数加上上一轮的res
                res[i] = res[start] + res[i - start];
            }
        }
        return res;
    }
}
