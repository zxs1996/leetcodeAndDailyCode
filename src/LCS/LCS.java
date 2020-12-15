package LCS;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2020/11/24 11:23
 */
public class LCS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入text1: ");
        String s3 = sc.next();
        System.out.print("请输入text2: ");
        String s4 = sc.next();
        System.out.println(s3 + "--" + s4);
        String res = new LCS().lcs(s3, s4);
        System.out.println(res);
    }

    @Test
    public void test1() {

        String s1 = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String s2 = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        //String s3 = "10010101";
        //String s4 = "010110110";


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

        if (text1 == null || text2 == null ||
                text1.length() == 0 || text2.length() == 0) return 0;

        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        int tmp;
        for (int i = 1; i <= m; i++) {
            int last = 0;//记录左上角的值，每一轮开始的时候值都是0
            for (int j = 1; j <= n; j++) {
                tmp = dp[j];//记录当前正上方的数
                //如果两个字符相等，那么等于左上角值+1
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[j] = last + 1;
                    //否则从左边和上边找一个较大的
                else dp[j] = Math.max(tmp, dp[j - 1]);
                last = tmp;//更新last，tmp变为左上角，下一轮使用
            }
        }
        return dp[n];
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