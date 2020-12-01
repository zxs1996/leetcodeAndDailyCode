package num_1_100;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/9.
 */
public class Num_59 {

    public static void main(String[] args) {
        int [][]res=new Num_59().generateMatrix(3);
        for (int [] nums:res) {
            System.out.println(Arrays.toString(nums));
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int number = 1;
        int count = n;
        int xx = 0, yy = 0;
        while (number <= n * n) {
            for (int i = 0; number<=n*n&&i < count; i++)
                res[xx][yy++] = number++;
            xx++;
            yy--;
            for (int i = 0; number<=n*n&&i < count - 1; i++)
                res[xx++][yy] = number++;
            xx--;
            yy--;
            for (int i = 0; number<=n*n&&i < count - 1; i++)
                res[xx][yy--] = number++;
            xx--;
            yy++;
            for (int i = 0;number<n*n&& i < count - 2; i++)
                res[xx--][yy] = number++;
            xx++;
            yy++;
            count -= 2;
        }
        return res;
    }
}
