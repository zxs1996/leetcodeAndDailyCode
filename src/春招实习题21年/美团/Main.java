package 春招实习题21年.美团;

import java.util.*;

/**
 * @author zxs666
 * @date 2021/4/4 9:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int mod = 20210101;
        if (str.length() == 0) {
            System.out.println(1);
            return;
        }

        int res = 1;
        for (int i = 1; i < str.length(); i++) {
            int cur = 0;
            for (int j = 0; j < i; j++)
                cur += cal(j, i - 1);
            res = (res + cur) % mod;
        }
        System.out.println(res);
    }

    public static int cal(int n, int m) {
        if (m == 0)
            return 1;
        return jiecheng(m) / (jiecheng(n) * jiecheng(m - n));
    }

    public static int jiecheng(int n) {

        int res = 1;
        for (int i = 1; i <= n; i++)
            res *= 1;
        return res;
    }

}
