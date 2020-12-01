package num_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/8.
 * N皇后和皇后二
 */
public class Num_51 {
    public static void main(String[] args) {
        List<List<String>> ans = new Num_51().solveNQueens(4);
        System.out.println(ans.size());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] pushed = new int[n];
        Arrays.fill(pushed, -1);
        dfs(res, pushed, 0, n);
        return res;
    }

    public void dfs(List<List<String>> res, int[] pushed, int row, int n) {
        //到结束了,将当前序列放入list
        if (row == n) {
            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer("");
                for (int j = 0; j < n; j++) {
                    if (pushed[i] == j)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                tempList.add(sb.toString());
            }
            res.add(tempList);
            return;
        }

        //继续往下递归
        //每个位置从左往右试
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            //判断前面已经放置的位置和当前的i是否冲突
            for (int j = 0; j < row; j++) {
                int xx = i - pushed[j];
                int yy = row - j;
                //如果列冲突或者斜方冲突
                if (pushed[j] == i || Math.abs(xx) == Math.abs(yy)) {
                    //System.out.println(row+","+i+",列冲突"+Arrays.toString(pushed));
                    flag = false;
                    break;
                }
            }
            //如果该位置不可行，找下一个位置
            if (!flag)
                continue;
            //该位置可行，将皇后放入，继续往下层走
            pushed[row] = i;
            dfs(res, pushed, row + 1, n);
            pushed[row] = -1;
        }
    }
}
