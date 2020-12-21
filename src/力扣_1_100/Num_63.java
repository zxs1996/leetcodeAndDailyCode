package 力扣_1_100;

public class Num_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        if(row==1&&col==1)
            return obstacleGrid[0][0]==1?0:1;

        if(obstacleGrid[0][0]==1)
            return 0;
        obstacleGrid[0][0] = 1;
        //初始第一行
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            //如果为1的话，表示阻碍，那么设为0
            if (obstacleGrid[0][i] == 1)
                obstacleGrid[0][i] = 0;
            else
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
        }
        //初始第一列
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1)
                obstacleGrid[i][0] = 0;
            else
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
        }

        for (int i = 1; i < obstacleGrid.length; i++)
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
