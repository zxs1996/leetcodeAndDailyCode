package num_501_600;

/**
 * @author zxs666
 * @date 2020/11/2 14:40
 *
 * 最长回文子序列
 * 类似于最长回文子数组
 * 动态规划解决
 */
public class Num_516 {


    //方式1，外层循环是数组长度，内层迭代下标
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0)
            return 0;

        int n=s.length();
        //dp[i][j]表示从i开始，j结束的回文子序列长度
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int i=0;i<n-1;i++)
            dp[i][i+1]=s.charAt(i)==s.charAt(i+1)?2:1;
        for(int distance=2;distance<n;distance++){
            for(int i=0;i<n-distance;i++){
                int j=i+distance;
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }

        return  dp[0][n-1];
    }

    //方式2，内外层都是数组下标，通过下标的差值来表示长度  推荐这个写法
    public int longestPalindromeSubseq2(String s) {
        if(s.length()==0)
            return 0;

        int n=s.length();
        //dp[i][j]表示从i开始，j结束的回文子序列长度
        int[][] dp=new int[n][n];

        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)==s.charAt(i))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }

        return  dp[0][n-1];
    }
}
