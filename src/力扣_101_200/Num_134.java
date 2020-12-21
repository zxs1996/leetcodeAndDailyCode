package 力扣_101_200;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/23.
 */
public class Num_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // 记录在某个位置的油量不能通过的最大油量
        int[] dp = new int[n];
        Arrays.fill(dp, -1);//初始为-1

        //遍历每一个起点
        for (int i = 0; i < n; i++) {
            //如果获得的油大于消耗的油那么可以从该点出发
            if (gas[i] - cost[i] > dp[i]) {
                int start = i;
                int leftGas = gas[i] - cost[i];
                //从下一个起点开始计算
                for (int j = i + 1; ; j++) {
                    j = j % n;
                    if (j == start)
                        return start;
                    //前一轮剩下的油量小于不能通过的最大油量，跳出
                    if (leftGas <= dp[j]) {
                        break;
                    }
                    //计算油量
                    leftGas += gas[j] - cost[j];
                    //不能通过的最大油量
                    if (leftGas < 0) {
                        dp[j] = Math.max(dp[j], leftGas - gas[j] + cost[j]);
                        break;
                    }
                }
            }
        }
        return -1;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;//总共的加油和耗油的差值
        int minSpare = Integer.MAX_VALUE;//从0开始的差值的最低点
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];//记录总加油和总耗油之间的差值
            if (spare < minSpare) {//更新最低点
                minSpare = spare;
                minIndex = i;
            }
        }

        //从最低点的下一个点出发，这样的话，相当于最低点是最后一个到达的站台，在前面的站台加更多的油
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

}
