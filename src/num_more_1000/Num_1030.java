package num_more_1000;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author zxs666
 * @date 2020/11/17 14:36
 */
public class Num_1030 {

    @Test
    public void test() {
        int[][] res = allCellsDistOrder(2, 3, 1, 2);
        System.out.println(Arrays.deepToString(res));
    }

    @Test
    public void test2() {
        double res = myPow(2, -10);
        System.out.println(res);
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int index = 0;
        boolean[][] visited = new boolean[R][C];
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<Integer, Integer>(r0, c0));
        visited[r0][c0] = true;
        while (index < R * C && !queue.isEmpty()) {
            Pair cur = queue.poll();
            int rr = (int) cur.getKey();
            int cc = (int) cur.getValue();
            res[index++] = new int[]{(int) cur.getKey(), (int) cur.getValue()};


            for (int dir[] : direction) {
                int newRR = rr + dir[0];
                int newCC = cc + dir[1];
                if (newRR >= 0 && newRR < R && newCC >= 0 && newCC < C && !visited[newRR][newCC]) {
                    visited[newRR][newCC] = true;
                    queue.add(new Pair<>(newRR, newCC));
                }

            }
        }

        return res;
    }


    public double myPow(double x, int n) {
        if ((x - 1) >= 0.0000)
            return x;
        int absN = Math.abs(n);
        double res = 1;
        for (int i = 0; i < absN; i++) {
            res *= x;
        }


        return n > 0 ? res : 1 / res;
    }
}
