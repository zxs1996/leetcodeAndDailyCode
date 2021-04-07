package 春招实习题21年.微众银行;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/4/6 18:57
 */
public class 第三题积木 {

   /*
 5
2 2 3 2 3

    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] res = new String[T];
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();
            Arrays.sort(arr);
            //不包括0，那么一定不组成
            if (arr[0] != 0) {
                res[i] = "-1";
                continue;
            }
            //超过1 最后一个数字也是0，
            if (n > 1 && arr[n - 1] == 0) {
                res[i] = "-1";
                continue;
            }
            int sum = 0;
            for (int j = 1; j < n; j++)
                sum += arr[j];
            if (sum % 3 == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = n - 1; j >= 0; j--)
                    sb.append(arr[j]);
                res[i] = sb.toString();
            }

            else
                res[i] = "-1";
        }

        System.out.println(Arrays.toString(res));
        for (int i = 0; i < T; i++)
            System.out.println(res[i]);
    }
}
