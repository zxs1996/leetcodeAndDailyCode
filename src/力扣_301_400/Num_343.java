package 力扣_301_400;

import org.junit.Test;

public class Num_343 {
    @Test
    public void test1() {
        integerBreak(10);
    }

    public int integerBreak(int n) {

        int dp[] = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j < i; j++)
                //每次从 dp[i] dp[j]*（i-j) (i-j)*j 里面找最大的
                dp[i] = Math.max(Math.max(dp[i], dp[j] * (i - j)), (i - j) * j);

        return dp[n];
    }
}
