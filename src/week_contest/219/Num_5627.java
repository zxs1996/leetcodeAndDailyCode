/**
 * @author zxs666
 * @date 2020/12/13 10:49
 */
public class Num_5627 {

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n];
        sum[0] = stones[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + stones[i];
        return 1;
    }
}
