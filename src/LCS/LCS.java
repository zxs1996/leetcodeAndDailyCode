package LCS;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/11/24 11:23
 */
public class LCS {

    @Test
    public void test1() {
        int[] dp=new int[3];
        System.out.println(Arrays.toString(dp));
        String s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        String s3 = "10010101";
        String s4 = "010110110";
        String res = lcs(s3, s4);
        System.out.println(res);
    }

    public String lcs(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        int[][] solution = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    solution[i + 1][j + 1] = 0;
                } else if (dp[i][j + 1] >= dp[i + 1][j]) {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                    solution[i + 1][j + 1] = 1;
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                    solution[i + 1][j + 1] = 2;//往左
                }

            }
        }
        System.out.println("最长lcs长度：" + dp[arr1.length][arr2.length]);
        return creataString(solution, arr1, arr2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()>text2.length()){
            String tmp=text1;
            text1=text2;
            text2=tmp;
        }
        int l1=text1.length();
        int l2=text2.length();
        int[] dp=new int[l1+1];
        for(int i=1;i<=l2;i++){
            for(int j=l1;j>0;j--){
                if(text1.charAt(j-1)==text2.charAt(i-1))
                    dp[j]=dp[j-1]+1;
                else
                    dp[j]=Math.max(dp[j],dp[j-1]);
            }
            //System.out.println( Arrays.toString(dp));
        }
        return dp[l1];

    }


    private String creataString(int[][] solution, char[] arr1, char[] arr2) {
        return recuser(solution, arr1, arr2, arr1.length, arr2.length);
    }

    public String recuser(int[][] solution, char[] arr1, char[] arr2, int i, int j) {
        if (i == 0 || j == 0)
            return "";
        if (solution[i][j] == 0) {
            return recuser(solution, arr1, arr2, i - 1, j - 1) + arr1[i - 1];
        } else if (solution[i][j] == 1)
            return recuser(solution, arr1, arr2, i - 1, j);
        else return recuser(solution, arr1, arr2, i, j - 1);
    }
}



/*
ppt:GTCGTCGGAAGCCGGCCGAA

my:GTCGTCGGAAGCCGGCCGAA
 */