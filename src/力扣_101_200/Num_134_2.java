package 力扣_101_200;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/11/18 21:51
 * <p>
 * O(N)解法：
 * 记录从0到每个点的剩余油量和，找到一个累积油量最低的点，然后从这个点的后一个点出发，看能不能够走一圈
 */
public class Num_134_2 {

    @Test
    public void test() {
        int[] gas = {3, 1, 2};
        int[] cost = {1, 2, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int lowest = Integer.MAX_VALUE;
        int curr = 0;
        int n = gas.length;
        int lowestIndex = 0;
        //先找一个累计油耗的最低点，从最低点后面出发开始找
        for (int i = 0; i < n; i++) {
            curr += gas[i] - cost[i];
            if (curr < lowest) {
                lowest = curr;
                lowestIndex = i;
            }
        }

        //从最低点的后面那个点开始找找，看能不能找一圈
        int start = (lowestIndex + 1) % n;
        int curGas = 0;
        //最多找n次，全部点都会找完
        for (int i = 0; i < n; start = (start + 1) % n, i++) {
            curGas += gas[start] - cost[start];
            //如果中间某个点剩余油量小于0，那么返回-1
            if (curGas < 0)
                return -1;
        }

        //循环如果能够顺利结束，说明，能够走一圈，那么返回start
        return start;
    }
}
