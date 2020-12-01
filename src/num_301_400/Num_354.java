package num_301_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zxs666
 * @date 2020/11/26 9:47
 */
public class Num_354 {

    @Test
    public void test() {
        int[][] nums = {{10, 8}, {1, 12}, {6, 15}, {2, 18}};
        int res = maxEnvelopes(nums);
    }


    /**
     * O(N²)解法，
     * 1、先按照宽度升序排列，在按照长度降序排列
     * 2、在上面排序的基础上使用dp算法，dp[i]表示前i封信所能取得的最大套娃数
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, Comparator.comparingInt(o1 -> o1[1]));
        Arrays.sort(envelopes, Comparator.comparingInt(o1 -> o1[0]));
        int n = envelopes.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[j] + 1, dp[i]);

            }
        }

        int max = 0;
        for (int num : dp)
            max = Math.max(max, num);

        return max;
    }


    /**
     * O(NlogN)解法
     * 1、先排序：先按照宽度降序排序，再按照长度升序排列，这样排列出来的结果是长度递增，相同长度的信按照宽度降序排列
     * 2、在O(N)时间下，对宽度找最长上升子序列，
     * 如 1 8
     * 2 3
     * 5 4
     * 5 2
     * 6 7
     * 6 4
     * 因为相同长度的信是按照宽度递减的，所以必然不会选择到相同长度的信：
     * 怎么理解：如果我选择了5 4，那么往后的找在长度为5上是必然找不到比4更宽的，因为宽度降序排列，
     */

    public int maxEnvelopes2(int[][] envelopes) {

        //对宽度降序排列
        Arrays.sort(envelopes, Comparator.comparingInt(o1 -> -o1[1]));
        //对长度升序排列
        Arrays.sort(envelopes, Comparator.comparingInt(o1 -> o1[0]));
        int n = envelopes.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    break;
                }
            }
        }

        int max = 0;
        for (int num : dp)
            max = Math.max(max, num);

        return max;
    }
}
