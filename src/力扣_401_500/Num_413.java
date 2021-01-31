package 力扣_401_500;

import org.junit.Test;

public class Num_413 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 8, 9, 10};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        //dp[i]表示以i结束的等差数列个数，这里每次只需要用到dp[i-1]，那么可以做空间复杂度上的优化
        int dp = 0;
        for (int i = 2; i < A.length; i++) {
            //统计以i结尾的等差数列的个数
            int count = 0;
            for (int j = i - 1; j > 0; j--) {
                //如果符合等差，那么count++,继续往前递归，否则返回
                if (A[i] - A[i - 1] == A[j] - A[j - 1])
                    count++;
                else
                    break;
            }
            //以i结尾的等差数列的个数==以i-1结尾的等差数列个数+这个结尾的
            dp += count;

        }
        return dp;
    }
}
