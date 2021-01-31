package 力扣_401_500;

/**
 * @author zxs666
 * @date 2020/10/30 16:44
 */
public class Num_463 {
    int[][] location = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int row = grid.length;
        if (row == 0)
            return 0;
        int column = grid[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++) {
                //如果是水，那么continue
                if (grid[i][j] == 0)
                    continue;
                //否则是陆地，做一些条件判断修改res
                //1、上下边界
                if (i == 0)
                    res++;
                if (i == row - 1)
                    res++;

                //2、左右边界
                if (j == 0)
                    res++;
                if (j == column - 1)
                    res++;


                //3、判断4个方向
                for (int k = 0; k < 4; k++) {
                    int xx = i + location[k][0];
                    int yy = j + location[k][1];
                    //如果位置合理，并且为空，那么++
                    if (xx >= 0 && xx < row && yy >= 0 && yy < column && grid[xx][yy] == 0)
                        res++;
                }
                System.out.println(i + " --" + j + "--" + res);
            }
        return res;
    }
}
