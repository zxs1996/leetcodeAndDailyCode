package 春招实习题21年.三六零;


import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/28 18:56
 */
public class Main {

    static int length = 100;

    public static void main(String[] args) {

        System.out.println(3^2);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            res += score[i];
        }
       if(n==0){
           System.out.println(0);
           return ;
       }
       if(n==1){
           System.out.println(res);
           return ;
       }
       if(n==2){
           res+=score[0]|score[1];
           System.out.println(res);
           return ;
       }


        //记录对应为为0的数量
        int[] zero = new int[length];
        int[] one = new int[length];
        Arrays.fill(zero, 0);
        Arrays.fill(one, 0);
        Arrays.sort(score);
        res += score[0] | score[1];
        for (int i = 0; i < 2; i++) {
            int[] cur = toArr(Long.toBinaryString(score[i]));
            for (int j = 0; j < length; j++) {
                if (cur[j] == 0)
                    zero[j]++;
                else
                    one[j]++;
            }

        }

        for (int i = 2; i < n; i++) {
            int[] cur = toArr(Integer.toBinaryString(score[i]));
            for (int j = 0; j < length; j++) {
                if (cur[j] == 1) {
                    res += Math.pow(2, j) * i;
                    one[j]++;
                } else {
                    res += Math.pow(2, j) * one[j];
                }
            }
        }

      /*  for (int i = 0; i < 33; i++)
            res += Math.pow(2, i) * arr[i];*/


        System.out.println(res);
    }

    public static int[] toArr(String str) {
        int index = 0;
        int[] arr = new int[length];
        Arrays.fill(arr, 0);
        for (int i = str.length() - 1; i >= 0; i--) {
            arr[index++] = str.charAt(i) - '0';
        }
        return arr;
    }


}
