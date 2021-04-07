package 力扣_1_100;

/**
 * @author zxs666
 * @date 2021/2/6 18:07
 */
public class Num_10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        //dp[i][j] 表示 s[0~i] 和p[0~j]能否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                //如果当前符号是'*'
                if (p.charAt(j - 1) == '*') {
                    //*匹配0个字符，转移到dp[i][j-2]上面去
                    dp[i][j] = dp[i][j - 2];
                    //查看i和j-1的匹配情况，如果i和j-1匹配得上，那么
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                //否则，按照'.'或者其他字符匹配
                else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    //s[i]和p[j]这个位置的字符能否匹配上  考虑3个问题，边界  '.' 和其他
    public boolean matches(String s, String p, int i, int j) {
        //边界 返回
        if (i == 0) {
            return false;
        }
        //如果是'.'的话，肯定能匹配成功
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        //不是*  不是.  看是否相等
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
