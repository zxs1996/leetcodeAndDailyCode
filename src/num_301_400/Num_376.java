package num_301_400;

import org.junit.Test;

import java.util.Random;

/**
 * @author zxs666
 * @date 2020/12/12 12:26
 */
public class Num_376 {

    @Test
    public void test() {
        int N = 100;
        int[] nums = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++)
            nums[i] = random.nextInt(1000);
        System.out.println(wiggleMaxLength(nums));
        System.out.println(wiggleMaxLength2(nums));

    }

    /**
     * 动态规划，O(N²)
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;
        if (n == 0)
            return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j])
                    continue;
                //如果j只有一个元素
                if (dp[j][0] == 1) {
                    if (dp[i][0] < 2) {
                        dp[i][0] = 2;
                        dp[i][1] = nums[i] - nums[j];
                    }
                } else {
                    if (dp[j][0] >= dp[i][0]) {
                        if ((nums[i] - nums[j] > 0 && dp[j][1] < 0) || (nums[i] - nums[j] < 0 && dp[j][1] > 0)) {
                            dp[i][0] = dp[j][0] + 1;
                            dp[i][1] = nums[i] - nums[j];
                        }
                    }

                }
            }
        return dp[n - 1][0];
    }


    /**
     * 贪心，O(N)
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int res = 1;
        int pre = nums[0];
        int flag = 0;//标志位
        for (int i = 1; i < nums.length; i++) {
            //如果相等，那么直接continue
            if (nums[i] == pre)
                continue;
            //如果是0，说明长度为1，这个元素可以加上去
            if (flag == 0) {
                res++;
                flag = nums[i] - pre > 0 ? 1 : -1;
                pre = nums[i];
            }
            //如果前面的差值为正数
            else if (flag == 1) {
                //当前差值为负数，满足摆动条件，flag翻转，res++
                if (nums[i] - pre < 0) {
                    flag = -1;
                    res++;
                }
                //将pre更新为当前值，注意，这个操作一定会做的，
                // 因为比如1 7 10  当我循环到10的时候我选择10，一定比选择7更优，因为找比10小的数更好找
                pre = nums[i];
            }
            //如果前面的差值为负数
            else if (flag == -1) {
                if (nums[i] - pre > 0) {
                    flag = 1;
                    res++;
                }
                pre = nums[i];
            }
        }
        return res;


    }
}
