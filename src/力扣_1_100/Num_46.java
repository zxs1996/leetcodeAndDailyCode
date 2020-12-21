package 力扣_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/5.
 */
public class Num_46 {

    public static void main(String[] args) {
        List<List<Integer>> ans=new Num_46().permute(new int[]{1,2,3});
        System.out.println("答案"+ans.size());
        for (List<Integer> list:ans) {

        }
    }
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean flag[] = new boolean[nums.length];
        Arrays.fill(flag, false);
        dfs(nums, flag, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, boolean flag[], List<Integer> path, int count) {
        //如果访问了全部，那么得到一个排列，添加到res，然后返回
        if (count == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果没被访问过,那么访问它
            if (!flag[i]) {
                flag[i] = true;
                path.add(nums[i]);
                dfs(nums, flag, path, count + 1);
                path.remove(path.size() - 1);
                flag[i] = false;
            }
        }

    }
}
