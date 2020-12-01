package num_701_800;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/10/31 19:59
 * 动态规划：
 * 思路：
 * dp[i][j]表示以第一个数组第i个元素做结尾，第二个数组第j个元素做结尾的公共数组长度
 * 状态转移函数：
 * if(A[i]==B[j])
 * dp[i][j]=dp[i-1][j-1]+1
 * <p>
 * 定义一个max记录这个过程中最大的的dp[i][j]，最后返回max
 * 注意：dp数组可以从1开始，下标为0的表示初值
 */
public class Num_718 {

    @Test
    public void test() {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3, 1, 2, 3};
        System.out.println(findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {
        //开dp数组的长度刚好是A长度+1 B长度+1，这样做的缺点是不需要初始化下标为0的情况
        int[][] dp = new int[A.length + 1][B.length + 1];
        //dp[i][j]表示以A数组下标i和B数组下标j结尾的公共字符串长度
        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                //如果元素值相等，那么在前一个元素基础上+1，并修改max
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return max;
    }


}
