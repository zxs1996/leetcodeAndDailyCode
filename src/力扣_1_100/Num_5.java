package 力扣_1_100;

/**
 * @author zxs666
 * @date 2021/1/29 19:19
 * 找出字符串s中的最长回文子串
 * 动态规划  由dp[i][j]可以推出dp[i-1][j+1]是否是回文串，过程中记录最长串的下标
 */
public class Num_5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return s;
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        int max = 1;
        int start = 0, end = 0;
        //k表示长度
        for (int k = 1; k < n; k++)
            for (int i = 0; i + k < n; i++) {
                //长度为1时单独提出来
                if (k == 1) {
                    dp[i][i + k] = arr[i] == arr[i + 1];
                } else {
                    dp[i][i + k] = (dp[i + 1][i + k - 1] && arr[i] == arr[i + k]);
                }
                if (dp[i][i + k] && k + 1 > max) {
                    start = i;
                    end = i + k;
                }
            }
        return s.substring(start, end + 1);
    }
}
