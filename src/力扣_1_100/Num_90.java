package 力扣_1_100;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/17.
 * 组合II，回溯剪枝
 */
public class Num_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先排序，保证有序
        Arrays.sort(nums);
        boolean flag[] = new boolean[nums.length];
        Arrays.fill(flag, true);//true表示没访问过
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(flag, true);//true表示没访问过
            dfs(res, flag, nums, 0, 0, i, new ArrayDeque<>());
        }

        return res;
    }

    public void dfs(List<List<Integer>> res, boolean[] flag, int nums[], int start, int count, int n, ArrayDeque<Integer> path) {
        if (count == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //如果被访问过，那么continue
            if (!flag[i])
                continue;
            //注意这里剪枝的细节
            //如果前一个元素跟当前元素相同，并且前一个元素没被访问过，去重
            if (i > 0 && nums[i] == nums[i - 1] && flag[i - 1])
                continue;
            //往下递归
            flag[i] = false;
            path.addLast(nums[i]);
            dfs(res, flag, nums, i + 1, count + 1, n, path);
            path.removeLast();
            flag[i] = true;
        }
    }
}
