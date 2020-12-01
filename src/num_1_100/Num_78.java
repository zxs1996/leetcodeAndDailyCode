package num_1_100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/14.
 */
public class Num_78 {

    public static void main(String[] args) {
        int nums[]={1,2,3};
        List<List<Integer>> res = new Num_78().subsets(nums);
        for (List<Integer> list:res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean flag[] = new boolean[n];
        Arrays.fill(flag,true);
        for (int i = 0; i <= n; i++){
            dfs(res, flag, nums, 0, 0, i, new ArrayDeque<>());
        }

        return res;
    }


    public void dfs(List<List<Integer>> res, boolean flag[], int[] nums, int start, int count, int k, ArrayDeque<Integer> path) {

        int n = nums.length;
        if (count == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n; i++) {
            //如果没被访问过
            if (flag[i]) {
                flag[i] = false;
                path.addLast(nums[i]);
                dfs(res, flag, nums, i + 1, count + 1, k, path);
                path.removeLast();
                flag[i] = true;
            }
        }
        return;
    }

}
