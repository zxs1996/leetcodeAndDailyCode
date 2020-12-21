package 力扣_301_400;

/**
 * @author zxs666
 * @date 2020/10/2 13:31
 */
public class Num_304 {
    class NumMatrix {
        int[][] matrix;
        int sum[][];

        public NumMatrix(int[][] matrix) {
            if(matrix.length==0)
                return ;
            this.matrix = matrix;
            sum = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                sum[i][0] = matrix[i][0];
                for (int j = 1; j < matrix[i].length; j++)
                    sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;
            for (int i = row1; i <= row2; i++)
                res += sum[i][col2] - sum[i][col1]+matrix[i][col1];
            return res;
        }
    }
}
