package 力扣_601_700;

/**
 * @author zxs666
 * @date 2021/2/21 23:32
 */
public class Num_695 {

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        return res;
    }

    public int dfs(int[][] grid, int x, int y) {

        int count = 1;

        for (int i = 0; i < 4; i++) {
            int newxx = x + direction[i][0];
            int newyy = y + direction[i][1];
            if (newxx >= 0 && newxx < grid.length && newyy >= 0 && newyy < grid[0].length && grid[newxx][newyy] == 1) {
                grid[newxx][newyy] = 0;
                count += dfs(grid, newxx, newyy);
            }
        }
        return count;
    }
}
