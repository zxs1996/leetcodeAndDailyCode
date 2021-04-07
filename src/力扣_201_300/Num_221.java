package 力扣_201_300;

//动态规划的思路，dp[i][j]表示以i ，j为右下角的最大正方形的边长

import java.util.HashSet;

public class Num_221 {
    public static void main(String[] args) {
        System.out.println();
    }


    /**
     * 更精简的写法
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        int m=matrix.length;
        if(m==0)
            return 0;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        //dp[i][j]表示以i j作为右下角的正方形最大边长
        for(int i=0;i<m;i++)
            dp[i][0]=matrix[i][0]=='1'?1:0;
        for(int j=0;j<n;j++)
            dp[0][j]=matrix[0][j]=='1'?1:0;

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                //每个点作为右下角的正方形的上限取决于dp[i-1][j-1]，也就是左上角，一定不能超过左上角。
                // 从该点开始，往上和往左同时走，如果不为0，则继续走，如果为0，那么终止，每次dp[i][j]++
                for(int k=0;k<=dp[i-1][j-1];k++){
                    if(matrix[i][j-k]=='0'||matrix[i-k][j]=='0')
                        break;
                    //当前正方形的边长+1
                    dp[i][j]++;
                }

            }
        int res=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                res=Math.max(res,dp[i][j]);
        return res*res;

    }

}
