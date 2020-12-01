package num_101_200;

/**
 * Created by zxs666 on 2020/8/1.
 */
public class Num_174 {
    //反向DP，从右下角往左上角dp
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];//dp[i][j]表示到i 行j列最少需要的健康值
        if (dungeon[m - 1][n - 1] >= 0)
            dp[m - 1][n - 1] = 1;
        else
            dp[m - 1][n - 1] = -dungeon[m - 1][n - 1] + 1;

        //初始最后一行,最右下角不处理
        for (int i = n - 2; i >= 0; i--) {
            //如果这个位置的健康值大于等于0
            if (dungeon[m - 1][i] >= 0) {
                int need = dp[m - 1][i + 1] - dungeon[m - 1][i];
                if (need <= 0)
                    dp[m - 1][i] = 1;
                else
                    dp[m - 1][i] = need;
            }
            //健康值小于等于0
            else
                dp[m - 1][i] = -dungeon[m - 1][i] + dp[m - 1][i + 1];
        }
        //初始化最后一列,最右下角不处理
        for (int i = m - 2; i >= 0; i--) {
            if (dungeon[i][n - 1] >= 0) {
                int need = dp[i + 1][n - 1] - dungeon[i][n - 1];
                if (need <= 0)
                    dp[i][n - 1] = 1;
                else
                    dp[i][n - 1] = need;
            } else
                dp[i][n - 1] = -dungeon[i][n - 1] + dp[i + 1][n - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int tempDp = Math.min(dp[i + 1][j], dp[i][j + 1]);
                if (dungeon[i][j] >= 0) {
                    int need = tempDp - dungeon[i][j];
                    if (need <= 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = need;
                } else
                    dp[i][j] = -dungeon[i][j] + tempDp;
            }
        }
        return dp[0][0];
    }
}