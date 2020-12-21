package 力扣_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/5.
 */
public class Num_40 {

    public static void main(String[] args) {
        int candidates[] = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> ans = new Num_40().combinationSum2(candidates, 8);
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        //从0开始
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int target, int start, List<Integer> path) {
        //如果target为0，那么找到一个组合，将其放入res，然后返回
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //从start开始
        for (int j = start; j < candidates.length; j++) {
            //剪枝，防止重复元素,如果前一个元素和当前元素相同，那么无论当前元素怎么组合，都会和前一个元素的组合重复。
            if (j > start && candidates[j] == candidates[j - 1])
                continue;
            //如果小于，那么不进入下一层。
            if (target < candidates[j])
                break;
            path.add(candidates[j]);
            //注意这里去到下一层使用的是j+1，保证不会重复使用到同一个元素
            dfs(candidates, target - candidates[j], j + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
