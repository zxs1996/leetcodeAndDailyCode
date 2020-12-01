package num_more_1000;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/10/31 21:55
 * 动态规划：
 * 两层循环遍历两个字符串
 * 外层遍历第一个字符串 i从1到数组长度
 * 内层遍历第二个字符串 j从1到数组长度
 * if text1[i]==text2[j]
 * dp[i][j]=dp[i-1][j-1]+1;
 * else
 * dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
 * <p>
 * 注意注意：这题和最长公共子数组的区别在于，公共子数组要求是连续的，
 * 公共子数组的dp[i][j]表示分别以 i j结尾的子数组长度，如果 text1[i]！=text2[j]，
 * 那么长度必然为0，因为它们至少一个元素不同，就不需要去比较前面的不同状态
 */
public class Num_1143 {


    //使用O(m*n)的空间复杂度
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++)
            for (int j = 1; j <= text2.length(); j++) {
                //如果当前text1[i]==text2[j]，那么直接等于dp[i-1][j-1]+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //否则从dp[i-1][j]和dp[i][j-1]里面挑个大的
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }

        return dp[text1.length()][text2.length()];
    }

    //使用O(2*n)的空间复杂度，n是较小的串长度
    public int longestCommonSubsequence_2(String text1, String text2) {
        //如果text1较长，那么交换顺序，保证text1是较短的串
        if (text1.length() > text2.length()) {
            return longestCommonSubsequence_2(text2, text1);
        }
        int m = text1.length();
        int n = text2.length();
        int[] dp1 = new int[m + 1];//记录当前轮的结果
        int[] dp2 = new int[m + 1];//记录上一轮的结果
        //外层循环长串
        for (int i = 1; i <= n; i++) {
            //内存循环短串
            for (int j = 1; j <= m; j++) {
                //如果相等，那么在上一轮的基础上+1
                if (text1.charAt(j - 1) == text2.charAt(i - 1))
                    dp1[j] = dp2[j - 1] + 1;
                    //否则从dp[i-1][j]和dp[i][j-1]里面选一个较大的
                    //dp2[j]相当于上一轮的i-1，也就是dp[i-1][j]
                    //dp1[j-1]相当于本轮的前一个，dp[i][j-1]
                else
                    dp1[j] = Math.max(dp2[j], dp1[j - 1]);
            }
            //更新dp2
            for (int k = 0; k <= m; k++)
                dp2[k] = dp1[k];
        }
        return dp1[n];
    }

    /**
     * 使用O(1*n)空间复杂度
     *
     * @param text1
     * @param text2
     * @return last:表示是当前dp[j](dp[i][j])左上角的数，相当于dp[i−1][j−1],初始化的时候为0
     * tmp:表示是当前dp[j](dp[i][j])正上方的数，相当于dp[i−1][j]
     * dp[j-1]:表示是当前dp[j](dp[i][j])左边的数，相当于dp[i][j−1]
     * 每一轮结束后，last的值都向前滚动一个，变成正上方的数，也就是tmp
     */
    public int longestCommonSubsequence3rd(String text1, String text2) {
        if (text1 == null || text2 == null ||
                text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        int tmp;
        for (int i = 1; i <= m; i++) {
            int last = 0;//记录左上角的值，每一轮开始的时候值都是0
            for (int j = 1; j <= n; j++) {
                tmp = dp[j];//记录当前正上方的数
                //如果两个字符相等，那么等于左上角值+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[j] = last + 1;
                    //否则从左边和上边找一个较大的
                else dp[j] = Math.max(tmp, dp[j - 1]);
                last = tmp;//更新last，tmp变为左上角，下一轮使用
            }
        }
        return dp[n];
    }


    @Test
    public void test2() {
        String text1 = "abcde";
        String text2 = "ace";
        int res = longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
}
