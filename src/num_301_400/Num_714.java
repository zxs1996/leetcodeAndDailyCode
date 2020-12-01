package num_301_400;

/**
 * Created by zxs666 on 2020/7/21.
 * 股票最大收益，有手续费
 */
public class Num_714 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int dp_0 = 0;//不持有股票
        int dp_1 = -prices[0] - fee;//持有股票
        for (int i = 1; i < n; i++) {
            int temp = dp_0;//保留dp_0
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            //持有股票的状态，可以从之前持有状态转过来，或者买入股票，但是注意买入交手续费
            dp_1 = Math.max(dp_1, temp - prices[i] - fee);
        }
        return dp_0;
    }
}
