package 春招实习题21年.美团;

import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/4/4 10:14
 */
public class 糖果 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] A = new int[n1];
        int[] B = new int[n2];
        for(int i=0;i<n1;i++)
            A[i]=sc.nextInt();

        for(int i=0;i<n2;i++)
            B[i]=sc.nextInt();
        int max_A=0;
        int sum_A = 0;
        for (int i = 0; i < n1; i++) {
            sum_A += A[i];
            max_A = Math.max(max_A, sum_A);
        }

        int max_B=0;
        int sum_B = 0;
        for (int i = 0; i < n2; i++) {
            sum_B += B[i];
            max_B = Math.max(max_B, sum_B);
        }
        System.out.println(max_A+max_B);

    }


}
