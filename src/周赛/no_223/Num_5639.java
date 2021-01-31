package 周赛.no_223;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @author zxs666
 * @date 2021/1/10 10:54
 */
public class Num_5639 {


    //记录最佳调度时间，初始化为Integer的最大值
    private int minTime = Integer.MAX_VALUE;

    /**
     * @param k    机器数量
     * @param jobs 每个任务需要耗费的时间
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);

        //记录每一台机器的结束时间，最终结束时间为所有机器中最晚的结束时间
        int endTime[] = new int[k];

        //先预分配，保证每台机器都安排一个工作，并且尽量先安排时间长的工作
        for (int i = 0; i < k; i++) {
            endTime[i] = jobs[jobs.length - i - 1];
        }
        jobs = Arrays.copyOfRange(jobs, 0, jobs.length - k);
        //递归的去尝试分配
        recurse(0, endTime, jobs, endTime[0]);
        return minTime;
    }

    /**
     * @param jobIndex      当前需要分配的工作下标
     * @param finishTime    记录每台机器的结束时间
     * @param cost          每个任务需要花费的时间
     * @param maxFinishTime 当前最晚的结束时间
     */
    public void recurse(int jobIndex, int[] finishTime, int[] cost, int maxFinishTime) {
        //剪枝
        if (maxFinishTime >= minTime)
            return;
        //如果所有工作都分配完了，判断需不需要更新minTime和ans
        if (jobIndex == cost.length) {
            if (minTime > maxFinishTime) {
                minTime = maxFinishTime;
            }
            return;
        }
        //依次选择用每一个机器完成当前第jobIndex项工作
        for (int i = 0; i < finishTime.length; i++) {
            finishTime[i] += cost[jobIndex];

            recurse(jobIndex + 1, finishTime, cost, Math.max(maxFinishTime, finishTime[i]));

            finishTime[i] -= cost[jobIndex];
        }
    }

}
