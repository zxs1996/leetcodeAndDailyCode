package 动态规划;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/19 16:58
 */
public class ChooseMFromN {
    @Test
    public void test() {
        int n=10,m=3;
        System.out.println(chooseMFromN(n,m));
        System.out.println(chooseMFromNWtihON(n,m));
    }


    //使用m*n空间
    public int chooseMFromN(int n, int m) {

        //dp[i][j]表示在i个物品中选择j个物品的方式数
        int[][] dp = new int[n + 1][m + 1];

        //初始化，在任意i个物品里面选0个物品的方式只有1种，那就是什么都不选
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i && j <= m; j++)
                //最优子结构 dp[i][j]的值等于dp[i-1][j](不选当前物品)+dp[i-1][j-1](选择当前物品)
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];

        return dp[n][m];
    }

    //使用m个空间
    public int chooseMFromNWtihON(int n, int m) {
        //使用一维空间O(m)，dp[i]表示在当前选择i个物品的组合数，
        int[] dp = new int[m + 1];
        dp[0] = 1;
        //外层循环物品
        for (int i = 0; i < n; i++) {
            //注意内层一定是从m到1，不然数据会被覆盖
            for (int j = m; j > 0; j--) {

                //dp[j]=dp[j](不选择当前物品)+dp[j-1](选择当前物品)
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[m];
    }
}
