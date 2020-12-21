package 回溯算法;

/**
 * @author zxs666
 * @date 2020/12/1 22:32
 * <p>
 * 工作分配问题
 * 设有n件工作要分配给n个人去完成，将工作i分配给第j个人所需费用为 Cij。
 * 试设计一个算法，为每个人分配1件不同的工作，并使总费用达到最小。
 */
public class JobAllocation {

    int res = Integer.MAX_VALUE;

    public int jobAllocate(int[][] spend) {
        int n = spend.length;
        boolean[] visited = new boolean[n];
        recurse(spend,visited,0,0);
        return res;
    }

    public void recurse(int[][] spend, boolean[] visited, int worker, int cost) {

        //剪枝
        if (cost >= res)
            return;
        //分配完了
        if (worker == visited.length) {
            res = Math.min(cost, res);
            return;
        }

        //分配
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recurse(spend, visited, worker + 1, cost + spend[worker][i]);
                visited[i] = false;
            }
        }
    }
}
