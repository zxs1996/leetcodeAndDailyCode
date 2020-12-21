package 力扣_201_300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_216 {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(new ArrayDeque<>(),1, k, 0, n);
        return res;
    }

    public void dfs(ArrayDeque<Integer> list,int start, int k, int count, int left_n) {
        if (count == k) {
            if (left_n == 0)
                res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < 10; i++) {
            if (i < left_n && count + 1 == k)
                continue;
            if (i > left_n)
                break;
            list.add(i);
            dfs(list,i+1, k, count + 1, left_n - i);
            list.removeLast();
        }
    }

}
