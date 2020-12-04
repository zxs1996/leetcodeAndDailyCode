package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/12/2 10:35
 */
public class BestDispatch {


    int res = Integer.MAX_VALUE;

    public int bestDispatch(int n, int k, int[] cost) {
        int endTime[] = new int[k];
        recurse(0, endTime, cost, 0);
        return res;
    }

    /**
     * @param jobIndex 当前工作下标
     * @param endTime  机器的结束时间
     * @param cost     每个工作的花费
     */
    public void recurse(int jobIndex, int[] endTime, int[] cost, int maxEnd) {
        if (maxEnd >= res)
            return;
        //如果所有工作都干完了
        if (jobIndex == cost.length) {
            res = Math.min(res, maxEnd);
            return;
        }
        //依次选择用每一个机器完成当前工作
        for (int i = 0; i < endTime.length; i++) {
            endTime[i] += cost[jobIndex];
            recurse(jobIndex + 1, endTime, cost, Math.max(maxEnd, endTime[i]));
            endTime[i] -= cost[jobIndex];
        }
    }


    @Test
    public void test(){
        int n=7;
        int k=3;
        int[] cost={2, 14 ,4, 16 ,6 ,5 ,3};
        int res=bestDispatch(n,k,cost);
        System.out.println(res);

    }
}
