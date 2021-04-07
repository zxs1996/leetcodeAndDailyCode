package 春招实习题21年.百度;

import sun.reflect.generics.tree.ArrayTypeSignature;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/30 19:26
 */
public class 数字跳跃 {

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

        //记录对应数字后面出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[N - 1], N - 1);
        int[] dp = new int[N];//dp[i]表示从当前点到最后位置的跳数

        dp[N - 1] = 0;//dp[i]表示从该点跳到最后点所需的最短条数
        for (int i = N - 2; i >= 0; i--) {
            if (map.containsKey(arr[i])) {
                dp[i] = Math.min(dp[map.get(arr[i])], dp[i + 1]) + 1;
            } else
                dp[i] = dp[i + 1] + 1;
            map.put(arr[i], i);
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[0]);
    }
}
