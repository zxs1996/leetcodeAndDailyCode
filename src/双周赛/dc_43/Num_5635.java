package 双周赛.dc_43;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2021/1/9 23:22
 */
public class Num_5635 {

    @Test
    public void test() {
        int[] res = constructDistancedSequence(2);
        System.out.println(Arrays.toString(res));
    }

    public int[] constructDistancedSequence(int n) {
        int[] res = new int[n * 2 - 1];
        Arrays.fill(res, 0);
        boolean[] visited = new boolean[n + 1];
        dfs(res, visited, 0);
        return res;
    }

    public boolean dfs(int[] res, boolean[] visited, int index) {
        if (index == res.length)
            return true;
        //当前已经放置了数
        if (res[index] != 0)
            return dfs(res, visited, index + 1);
        //尝试放2~n,从大往小放
        for (int i = visited.length-1; i > 1; i--) {
            if (!visited[i]) {
                if (index + i < res.length && res[index + i] == 0) {
                    res[index] = i;
                    res[index + i] = i;
                    visited[i] = true;
                    if (dfs(res, visited, index + 1))
                        return true;
                    visited[i] = false;
                    res[index] = 0;
                    res[index + i] = 0;
                }
            }
        }
        //尝试放1
        if (!visited[1]) {
            res[index] = 1;
            visited[1] = true;
            if (dfs(res, visited, index + 1))
                return true;
            visited[1] = false;
            res[index] = 0;
        }
        return false;
    }
}
