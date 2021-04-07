package 春招实习题21年.三六零;

import java.lang.reflect.Member;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/28 20:26
 */
public class 热气球 {

    public static void main(String[] args) {
        System.out.println(3^0);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int distance[] = new int[N];
        int money[] = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = scanner.nextInt();
            money[i] = scanner.nextInt();
        }

        int[][] dp = new int[N][K + 1];//dp[i][j]表示到第i个点，飞行j次所获得的最大金币数
        for (int i = 0; i <= K; i++) {
            dp[0][i] = money[0];
        }

        //循环K次
        for (int i = 1; i <= K; i++) {
            //从每个点出发
            for (int j = 0; j < N; j++) {
                if (dp[j][i - 1] != 0) {
                    for (int z = j + 1; z < N && distance[z] - distance[j] <= M; z++) {
                        dp[z][i] = Math.max(dp[z][i], dp[j][i - 1] + money[z]);
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<N;i++)
            for(int j=0;j<=K;j++)
                max=Math.max(max,dp[i][j]);
        System.out.println(max); ;
    }
}
