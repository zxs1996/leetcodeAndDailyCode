package 力扣_1_100;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/19 13:26
 */
public class Num_48 {

    @Test
    public void test() {
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);
        //System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++){
            doRotate(matrix, i, n - 1 - i);
        }



    }

    public void doRotate(int[][] matrix, int start, int end) {
        if (start >= end)
            return;
        for (int i = start; i < end; i++) {
            int rightNum = matrix[start + (i - start)][end];
            matrix[start + (i - start)][end] = matrix[start][i];

            int bottomNum = matrix[end][end - (i - start)];
            matrix[end][end - (i - start)] = rightNum;

            int leftNum = matrix[end - (i - start)][start];
            matrix[end - (i - start)][start] = bottomNum;

            matrix[start][i] = leftNum;
            //System.out.println(i+" "+Arrays.deepToString(matrix));

        }

    }


}
