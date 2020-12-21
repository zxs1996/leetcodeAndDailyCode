package 力扣_1_100;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/9.
 */
public class Num_60 {

    public static void main(String[] args) {
        System.out.println(new Num_60().getPermutation(3, 3));
    }

    int count = 0;
    String str = null;

    public String getPermutation(int n, int k) {
        int res[] = new int[n];
        boolean flag[] = new boolean[n];
        Arrays.fill(flag, false);
        int temp = 1;
        //优化一下
        for (int i = 1; i < n; i++)
            temp *= i;
        int div = k / temp;
        //如果整除
        if (k % temp == 0) {
            if (div == 0 || div == 1)
                dfs(0, 0, res, flag, k);
            else
                dfs(div - 1, 0, res, flag, k-temp*(div-1));
            ;
        } else
            dfs(div, 0, res, flag, k-temp*div);
        return str;
    }

    public void dfs(int start, int height, int[] res, boolean[] flag, int k) {
        if (height == res.length) {
            count++;
            if (count == k) {
                StringBuffer sb = new StringBuffer("");
                for (int i = 0; i < res.length; i++)
                    sb.append(res[i]);
                str = sb.toString();
            }
        } else {
            for (int i = start; i < res.length; i++) {
                //如果为true，说明被访问过，下一个
                if (flag[i])
                    continue;
                if (count == k)
                    break;
                flag[i] = true;
                res[height] = i + 1;
                dfs(0, height + 1, res, flag, k);
                flag[i] = false;
            }
        }
    }
}
