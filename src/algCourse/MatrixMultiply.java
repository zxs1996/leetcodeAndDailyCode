package algCourse;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/11/23 23:06
 */
public class MatrixMultiply {

    int num[][] = {{5, 10}, {10, 3}, {3, 12}, {12, 5}, {5, 10}, {50, 6}};

    @Test
    public void test() {
        int res = getMin(num);
        System.out.println(res);
    }

    public int getMin(int[][] a) {
        int n = a.length;
        //数组多开一维，从1开始计数
        int[][] dp = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];//记录括号的位置，用于后面打印
        //将矩阵链放到一个一维数组存
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++)
            nums[i] = a[i][0];
        nums[n] = a[n - 1][1];

        for (int len = 1; len < n; len++) {
            for (int i = 1; i < n + 1 - len; i++) {
                int k = i + len;
                dp[i][k] = Integer.MAX_VALUE;
                for (int j = i; j < k; j++) {
                    int cur = dp[i][j] + dp[j + 1][k] + nums[i - 1] * nums[j] * nums[k];
                    if (cur < dp[i][k]) {
                        dp[i][k] = cur;//更新当前最短链长度
                        s[i][k]=j;//记录i到k的划分界j
                    }
                    //dp[i][k] = Math.min(dp[i][k], dp[i][j] + dp[j + 1][k] + nums[i - 1] * nums[j] * nums[k]);

                }
                //System.out.println(dp[i][i+dis]);
            }
        }

        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(dp[i]));

        printKuohao(s,1,n);
        System.out.println("");
        return dp[1][n ];
    }

    public void printKuohao(int[][] s,int i,int j){
        if(i==j)
            System.out.print("A"+i);
        else{
            System.out.print("(");
            printKuohao(s,i,s[i][j]);
            printKuohao(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }


}



