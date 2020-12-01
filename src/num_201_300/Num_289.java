package num_201_300;

import org.junit.Test;

import java.util.Arrays;

public class Num_289 {
    @Test
    public void demo() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = nums.clone();
        nums2[2] = 111;
        nums[1]=1230;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }

    public void gameOfLife(int[][] board) {
        int[] rows = {0, 1, -1};
        int[] cols = {0, 1, -1};
        int[][] board2 = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board2[i][j]=board[i][j];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                int liveCeil = 0;
                for (int m = 0; m < 3; m++)
                    for (int n = 0; n < 3; n++) {
                        int newRow = i + rows[m];
                        int newCol = j + cols[n];

                        //几种特殊情况continue
                        if (m == 0 && n == 0)
                            continue;
                       else if (newRow < 0 || newCol < 0)
                            continue;
                        else if (newRow >= board.length || newCol >= board[0].length)
                            continue;
                        if (board2[newRow][newCol] == 1)
                            liveCeil++;
                    }
                System.out.print(liveCeil + "  ");
                //如果是活细胞，周围活细胞小于2或者大于3那么该细胞死亡
                if (board2[i][j] == 1 && (liveCeil < 2 || liveCeil > 3))
                    board[i][j] = 0;
                    //如果是死细胞，周围细胞数为3，那么复活
                else if (board2[i][j] == 0 && liveCeil == 3)
                    board[i][j] = 1;

            }
    }
}
