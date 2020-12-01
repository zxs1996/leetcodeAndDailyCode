package num_1_100;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/14.
 */
public class Num_77 {
    public static void main(String[] args) {
        List<List<Integer>> res = new Num_77().combine(4,2);
        for (List<Integer> list:res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        dfs(res, flag,1, n, 0, k, new ArrayDeque<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, boolean flag[],int start, int n, int count, int k, ArrayDeque<Integer> path) {
        if (count == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            //如果没被访问过
            if (flag[i]) {
                flag[i] = false;
                path.addLast(i);
                dfs(res, flag,i+1, n, count + 1, k, path);
                path.removeLast();
                flag[i] = true;
            }
        }

        return;
    }
}
