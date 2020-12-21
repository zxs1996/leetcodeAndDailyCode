package 力扣_601_700;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/18 13:39
 */
public class Num_647 {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        for (int k = 2; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                if (s.charAt(i) == s.charAt(i + k) && dp[i + 1][i + k - 1])
                    dp[i][i + k] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (dp[i][j])
                    res++;

        return res;

    }

    @Test
    public void test1(){
        countSubstrings2("aba");
    }

    public int countSubstrings2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res=0;
        //间距j
        for(int j=0;j<n;j++)
            //起点i
            for(int i=0;i+j<n;i++){
                if(s.charAt(i+j)==s.charAt(i)){
                    if(dp[i][i+j]=(j<=1||dp[i+1][i+j-1]))
                        res++;
                }
                System.out.println(i+"--"+(j+i)+"--"+res);
            }

        return res;

    }

}
