package 动态规划;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2021/3/8 22:02
 */
public class LongestPublicString {
    @Test
    public void test() {
        String s1 = "abcdefghijklmn";
        String s2 = "sdfsdfghijkzmn";
        System.out.println(longPubStr(s1, s2));
        System.out.println(longPubStr2(s1,s2));
    }

    public String longPubStr(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        String res = "";

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                if (dp[i][j] > res.length()) {
                    res = s1.substring(i - 1 - dp[i - 1][j - 1], i);
                }
            }

        return res;
    }

    public String longPubStr2(String s1, String s2) {
        String res = "";
        for (int i = 0; i < s1.length(); i++)
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    int count = 0;
                    while ((i+count)<s1.length()&&(j+count)<s2.length()&&s1.charAt(i + count) == s2.charAt(j + count))
                        count++;

                    if (count > res.length())
                        res = s1.substring(i, i + count);
                }

            }

        return res;
    }
}
