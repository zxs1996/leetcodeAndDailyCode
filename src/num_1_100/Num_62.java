package num_1_100;

/**
 * Created by zxs666 on 2020/7/18.
 */
public class Num_62 {

    public static void main(String[] args) {
        int res=new Num_62().uniquePaths(3,2);
        System.out.println(res);
    }
    public int uniquePaths(int m, int n) {
        if(m==0||n==0)
            return 0;
        int dp[][] = new int[m][n];

        //初始化第一列
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        //初始化第一行
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m-1][n-1];
    }
}
