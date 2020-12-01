package num_101_200;

/**
 * Created by zxs666 on 2020/8/1.
 */
public class Num_200 {
    public static void main(String[] args) {
        System.out.println(5&7);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                //如果是陆地并且没有被访问过,那么dfs它
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(visited, grid, i, j);
                }
            }
        return res;
    }

    public void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        visited[i][j] = true;
        //往上
        if (i > 0 && grid[i - 1][j] == '1' && !visited[i - 1][j])
            dfs(visited, grid, i - 1, j);
        //往下
        if (i < grid.length-1 && grid[i + 1][j] == '1' && !visited[i + 1][j])
            dfs(visited, grid, i + 1, j);
        //往左
        if (j > 0 && grid[i][j - 1] == '1' && !visited[i][j - 1])
            dfs(visited, grid, i, j - 1);
        //往右
        if (j < grid[0].length-1 && grid[i][j + 1] == '1' && !visited[i][j + 1])
            dfs(visited, grid, i, j + 1);
    }
}
