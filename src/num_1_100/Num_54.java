package num_1_100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/8.
 */
public class Num_54 {

    public static void main(String[] args) {
        int matrix[][] = {{}};

        List<Integer> ans = new Num_54().spiralOrder(matrix);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new ArrayList<>();
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        List<Integer> res = new ArrayList<>();
        int xx = 0, yy = 0;
        int sum = n * m;
        while (sum > 0) {
            //System.out.println(Arrays.toString(res.toArray()) + "," + sum);
            //往右
            for (int i = 0; i < n && sum > 0; i++, sum--)
                res.add(matrix[xx][yy++]);
            xx++;
            yy--;
            //往下
            for (int i = 0; i < m - 1 && sum > 0; i++, sum--)
                res.add(matrix[xx++][yy]);
            xx--;
            yy--;
            //往左
            for (int i = 0; i < n - 1 && sum > 0; i++, sum--)
                res.add(matrix[xx][yy--]);
            xx--;
            yy++;
            //往上
            for (int i = 0; i < m - 2 && sum > 0; i++, sum--)
                res.add(matrix[xx--][yy]);
            xx++;
            yy++;
            //下一轮，m n分别减2
            m -= 2;
            n -= 2;
        }
        return res;
    }


    @Test
    public void test(){
        int[][] matrix={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        spiralOrder2(matrix);

    }

    public int[] spiralOrder2(int[][] matrix) {

        int m=matrix.length;
        if(m==0)
            return new int[0];
        int n=matrix[0].length;
        int[] res=new int[m*n];

        int times=(int)Math.ceil((double)Math.min(m,n)/2);
        int index=0;

        for(int i=0;i<times;i++){
            int x=i,y=i;

            for(;y<n-i;y++)
                res[index++]=matrix[x][y];
            System.out.println(x+", "+y);
            y--;
            x++;

            for(;x<m-i;x++)
                res[index++]=matrix[x][y];
            System.out.println(x+","+y);
            x--;
            y--;
            for(;y>=i&&index<m*n;y--)
                res[index++]=matrix[x][y];

            System.out.println(x+", "+y);
            y++;
            x--;
            for(;x>i&&index<m*n;x--)
                res[index++]=matrix[x][y];
            System.out.println(x+", "+y);
            System.out.println(Arrays.toString(res));
        }
        return res;
    }
}
