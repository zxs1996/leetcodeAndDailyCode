package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/29.
 */
public class Num_171 {
    public static void main(String[] args) {
        System.out.println(new Num_171().titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        int res = 0;
        int mi = 0;
        for (int i = s.length() - 1; i >= 0; i--, mi++)
            res += (s.charAt(i)-'A'+1) * Math.pow(26, mi);
        return res;
    }

}
