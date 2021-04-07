package 春招实习题21年.微众银行;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/4/6 18:57
 */
public class 第一题 {

   /*
 5
2 2 3 2 3

    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i - 1]);

        for (int i = n - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], arr[i + 1]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= left[i] && arr[i] >= right[i])
                res++;
        }
        System.out.println(res);
    }
}
