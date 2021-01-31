package 回溯算法.最佳调度问题;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/2 10:35
 */
public class BestDispatch {


    //记录最佳调度时间，初始化为Integer的最大值
    private double minTime = Integer.MAX_VALUE;
    //记录最佳调度方案
    private Deque[] ans;

    /**
     * @param n    任务数量
     * @param k    机器数量
     * @param cost 每个任务需要耗费的时间
     * @return 返回值是一个数组，数组第一个元素是最佳调度的时间，第二个元素是最佳调度的具体方案
     */
    public Object[] bestDispatch(int n, int k, double[] cost) {

        ans = new Deque[k];

        //记录每一台机器的结束时间，最终结束时间为所有机器中最晚的结束时间
        double endTime[] = new double[k];

        //记录回溯过程中每一台机器上分配的任务编号
        Deque<Integer>[] queueArr = new Deque[k];
        for (int i = 0; i < k; i++)
            queueArr[i] = new ArrayDeque<Integer>();

        //递归的去尝试分配
        recurse(0, endTime, cost, queueArr, 0);
        return new Object[]{minTime, ans};
    }

    /**
     * @param jobIndex      当前需要分配的工作下标
     * @param finishTime    记录每台机器的结束时间
     * @param cost          每个任务需要花费的时间
     * @param queueArr      当前机器的分配情况，即每台机器分配了哪些任务
     * @param maxFinishTime 当前最晚的结束时间
     */
    public void recurse(int jobIndex, double[] finishTime, double[] cost, Deque[] queueArr, double maxFinishTime) {
        //剪枝
        if (maxFinishTime >= minTime)
            return;
        //如果所有工作都分配完了，判断需不需要更新minTime和ans
        if (jobIndex == cost.length) {
            if (minTime > maxFinishTime) {
                minTime = maxFinishTime;
                for (int i = 0; i < queueArr.length; i++)
                    ans[i] = new ArrayDeque(queueArr[i]);
            }
            return;
        }
        //依次选择用每一个机器完成当前第jobIndex项工作
        for (int i = 0; i < finishTime.length; i++) {
            finishTime[i] += cost[jobIndex];
            queueArr[i].add(jobIndex);//将jobIndex放到第i台机器的任务队列上面去
            recurse(jobIndex + 1, finishTime, cost, queueArr, Math.max(maxFinishTime, finishTime[i]));
            queueArr[i].removeLast();//从队列后面移除
            finishTime[i] -= cost[jobIndex];
        }
    }

}
