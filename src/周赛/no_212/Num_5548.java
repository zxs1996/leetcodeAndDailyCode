import org.junit.Test;

import javax.xml.transform.Source;
import java.rmi.ConnectIOException;
import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/10/25 11:39
 */
public class Num_5548 {


    private boolean[][] visited;
    private int[][] matrix;
    private int min = Integer.MAX_VALUE;
    private int[][] matrixMin;
    private int row;
    private int column;
    int[] arr1 = {-1, 1, 0, 0};
    int[] arr2 = {0, 0, -1, 1};


    public int minimumEffortPath(int[][] heights) {
        matrix = heights;
        row = heights.length;
        column = heights[0].length;
        visited = new boolean[row][column];
        //表示到当前位置的最短距离，用于剪枝
        matrixMin = new int[row][column];
        for (int i = 0; i < row; i++)
            Arrays.fill(matrixMin[i], Integer.MAX_VALUE);
        dfs(0, 0, 0);
        return min;
    }

    //i j 分别为当前格子的坐标，currentDistance表示到目前为止当前路径的最大差值
    public void dfs(int xx, int yy, int currentDistance) {
        if (currentDistance >= matrixMin[xx][yy])
            return;
        else {
            matrixMin[xx][yy] = currentDistance;
        }
        if (currentDistance >= min||matrixMin[xx][yy]>=min)
            return;
        //如果到达边界
        if (xx == row - 1 && yy == column - 1) {
            min = Math.min(min, currentDistance);
            return;
        }

        //设访问标志为true
        visited[xx][yy] = true;
        //从4个方向走
        for (int i = 0; i < 4; i++) {
            int new_xx = xx + arr1[i];
            int new_yy = yy + arr2[i];
            if (new_xx >= row || new_xx < 0 || new_yy >= column || new_yy < 0 || visited[new_xx][new_yy])
                continue;
            int temp = Math.abs(matrix[new_xx][new_yy] - matrix[xx][yy]);
            int max = Math.max(temp, currentDistance);
            dfs(new_xx, new_yy, max);
        }
        //设置访问标志为false
        visited[xx][yy] = false;
        matrixMin[xx][yy] = Math.min(min,matrixMin[xx][yy]);
    }


    @Test
    public void test() {

    }
}
