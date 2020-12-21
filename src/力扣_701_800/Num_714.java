package 力扣_701_800;

/**
 * @author zxs666
 * @date 2020/12/17 14:11
 * <p>
 * 买卖股票，有手续费
 */
public class Num_714 {
    //贪心算法
    //当前价格只要大于买入价格+手续费，那么我就选择卖出
    //考虑一个问题 [1,3,7,5,10,3] 手续费为3
    //如果1买7卖，5买10买，那么利润为5，但是如果我1买10卖，那么利润为6
    //所以我卖出去，下次再买卖的利润必须要大于
    //这个时候买入价格更新为卖出价格-手续费
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int inPrice = prices[0];//inPrice表示当前的买入价格

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > inPrice + fee) {
                res += (prices[i] - fee) - inPrice;
                //买入价格更新为price[i]-fee，表示当前买入的价格
               //下一次买入的值必须要低于本次卖出价格-fee，那么才有得赚
                //比如1 7 5 10（fee为3），我在7卖了，那么下次至少要小于4买入，我才有的赚
                inPrice = prices[i] - fee;//关键代码
            }
            //修改买入股票的值
            else if (prices[i] < inPrice)
                inPrice = prices[i];
        }

        return res;
    }

    //动态规划
    //dp_0表示当前不持有股票
    //dp_1表示当前持有股票
    public int maxProfitDp(int[] prices, int fee) {
        if (prices.length <= 1)
            return 0;
        //初始化两个状态
        int dp_0 = 0;
        int dp_1 = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp_0;//先把dp_0保存一下，不然dp_1的时候会被覆盖
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);//dp_0可以从上一轮的两个状态转过来
            dp_1 = Math.max(dp_1, tmp - fee - prices[i]);//dp_1也可以从上一轮的两个状态转过来
        }
        return dp_0;
    }

}
