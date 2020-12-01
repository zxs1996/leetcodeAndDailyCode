package num_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/2.
 */
public class Num_39 {


    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    int length;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        length = candidates.length;
        dfs(candidates, 0, target);
        return ans;
    }

    public void dfs(int[] candidates, int index, int leftValue) {
        if (leftValue == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //从index开始，不会向前下标小的回溯，保证程序返回且不重复。
        for (int i = index; i < length; i++) {
            if (leftValue < candidates[i])
                break;
            path.add(candidates[i]);
            //注意这里的下标是从i开始，这样就防止往前重复回溯
            dfs(candidates, i, leftValue - candidates[i]);
            path.remove(path.size() - 1);//移除刚才添加的元素
        }
    }
}
