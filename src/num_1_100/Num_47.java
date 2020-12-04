package num_1_100;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/8.
 */
public class Num_47 {


    public static void main(String[] args) {
        int nums[] = {1, 1, 2};
        List<List<Integer>> ans = new Num_47().permuteUnique(nums);
        System.out.println(ans.size());

    }

    List<List<Integer>> res = new ArrayList<>();
    boolean flag[];

    public List<List<Integer>> permuteUnique(int[] nums) {
        flag = new boolean[nums.length];
        Arrays.fill(flag, true);
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayDeque<Integer>());
        return res;
    }

    public void dfs(int[] nums, int count, Deque<Integer> path) {

        if (count == nums.length) {

            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //剪枝,条件为：i>0  nums[i] == nums[i - 1]  且前一个元素没被访问过
            // 比如 1 1 2
            //如果前一个元素已经被访问了，那么这个元素不是作为一个新的元素
            if (i > 0 && nums[i] == nums[i - 1] && flag[i - 1])
                continue;
            //如果为true，表示没被访问过
            if (flag[i]) {
                flag[i] = false;
                path.addLast(nums[i]);
                //从i+1开始，
                dfs(nums, count + 1, path);
                path.removeLast();
                flag[i] = true;
            }
        }
    }
}
