package 春招实习题21年.百度;

import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/30 19:26
 */
public class 数字跳跃2 {

    /**
     * 5 01212
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = str.charAt(i) - '0';

        int[] dp = new int[10];//表示最近的点，dp[4]=4，表示4经过最短4步就可到达
        int[] flag = new int[N];
        flag[N - 1] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[arr[N - 1]] = 1;
        for (int i = N - 2; i >= 0; i--) {
            int number = arr[i];
            int nextNumber = arr[i + 1];
            if (dp[number] > dp[nextNumber]) {
                dp[number] = dp[nextNumber] + 1;
                flag[i] = dp[number];
            } else
                flag[i] = dp[number];
        }
        //System.out.println(Arrays.toString(flag));
        System.out.println(flag[0] != 0 ? flag[0] : flag[0] + 1);

    }
}
