package 春招实习题21年.京东;

import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/27 19:40
 */
public class 防水板砖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        if (m == 0 || n == 0) {
            System.out.println(0);
            return;
        }
        int res = calculate(arr);
        System.out.println(res);
    }

    public static int calculate(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        //记录上方的最大值
        int[][] shang = new int[m][n];
        int[][] xia = new int[m][n];
        int[][] zuo = new int[m][n];
        int[][] you = new int[m][n];

        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                flag[i][j] = false;
        //记录上
        for (int j = 0; j < n; j++)
            for (int i = 1; i < m; i++)
                shang[i][j] = Math.max(shang[i - 1][j], arr[i - 1][j]);
        //记录下
        for (int j = 0; j < n; j++)
            for (int i = m - 2; i >= 0; i--)
                xia[i][j] = Math.max(xia[i + 1][j], arr[i + 1][j]);

        //记录左
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                zuo[i][j] = Math.max(zuo[i][j - 1], arr[i][j - 1]);

        //记录右
        for (int i = 0; i < m; i++)
            for (int j = n - 2; j >= 0; j--)
                you[i][j] = Math.max(you[i][j + 1], arr[i][j + 1]);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {

            }

        int res = 0;
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++) {
                if (shang[i][j] > arr[i][j] && xia[i][j] > arr[i][j] && zuo[i][j] > arr[i][j] && you[i][j] > arr[i][j]) {
                    flag[i][j] = true;
                    if (!(flag[i - 1][j] || flag[i][j - 1]))
                        res++;
                }
            }
        return res;
    }

    public static int maxABC(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
