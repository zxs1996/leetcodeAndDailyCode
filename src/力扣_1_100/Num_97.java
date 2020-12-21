package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/18.
 * 解法1：dfs 回溯 时间复杂度高
 * 解法2：动态规划，类似62题不同路径
 */
public class Num_97 {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean res = new Num_97().isInterleave2(s1, s2, s3);
        System.out.println(res);
    }


    //第一种算法，dfs回溯，时间复杂度高
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        if (arr1.length + arr2.length != arr3.length)
            return false;
        return dfs(arr1, arr2, arr3, 0, 0, 0);
    }

    public boolean dfs(char[] arr1, char[] arr2, char[] arr3, int i1, int i2, int i3) {
        //到达最后一个字符
        if (i3 == arr3.length) {
            return true;
        }
        if (i1 < arr1.length && arr1[i1] == arr3[i3]) {
            boolean res = dfs(arr1, arr2, arr3, i1 + 1, i2, i3 + 1);
            if (res)
                return res;
        }
        if (i2 < arr2.length && arr2[i2] == arr3[i3]) {
            boolean res = dfs(arr1, arr2, arr3, i1, i2 + 1, i3 + 1);
            if (res)
                return res;
        }
        return false;
    }


    //第二种算法，动态规划，类似num62不同路径算法
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int m = s1.length();
        int n = s2.length();

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //确定第一列
        for (int i = 1; i <= m && dp[i - 1][0] && arr1[i - 1] == arr3[i - 1]; i++)
            dp[i][0] = true;
        //确定第一行
        for (int j = 1; j <= n && dp[0][j - 1] == true && arr2[j - 1] == arr3[j - 1]; j++)
            dp[0][j] = true;


        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                //注意这里arr3的角标i+j-1,只用减去1，不是减2
                if (dp[i - 1][j] && arr1[i - 1] == arr3[i + j - 1])
                    dp[i][j] = true;
                if (dp[i][j - 1] && arr2[j - 1] == arr3[i + j - 1])
                    dp[i][j] = true;
            }
        show(dp);
        return dp[m][n];
    }

    public void show(boolean dp[][]) {

        int m = dp.length;
        int n = dp[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j])
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
        }

    }

}
