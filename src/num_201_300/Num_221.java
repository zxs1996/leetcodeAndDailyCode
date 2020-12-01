package num_201_300;

//动态规划的思路，dp[i][j]表示以i ，j为右下角的最大正方形的边长

public class Num_221 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        //初始第一行
        for (int i = 0; i < col; i++)
            dp[0][i] = matrix[0][i] == '0' ? 0 : 1;
        //初始第一列
        for (int i = 0; i < row; i++)
            dp[i][0] = matrix[i][0] == '0' ? 0 : 1;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //如果是0的话
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                    //如果是1，以该点为右下角，往左上角开始找
                else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = 1;
                    //往左上角找
                    for (int k = 1; k <= min; k++, dp[i][j]++) {
                        if (dp[i - k][j - k] == 0)
                            break;
                    }

                }
            }
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (dp[i][j] > res)
                    res = dp[i][j];
            }
        return res * res;
    }
}
