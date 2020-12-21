package 回溯算法;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/1 10:46
 */
public class NQuene {


    //int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int res = 0;

    public int N_qune(int n) {
        boolean[][] puts = new boolean[n][n];
        recur(puts, 0, n);
        return res;
    }

    public void recur(boolean[][] puts, int x, int n) {
        if (x == n) {
            res++;
           // print(puts);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(puts, x, i,n)) {
                puts[x][i] = true;
                recur(puts, x + 1, n);
                puts[x][i] = false;
            }
        }
    }

    public boolean isValid(boolean[][] puts, int x, int y,int n) {
        for (int i = 0; i < x; i++) {
           for(int j=0;j<n;j++){
               if(puts[i][j]&&(puts[i][y]||Math.abs(x-i)==Math.abs(y-j)))
                   return false;
           }
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(N_qune(15));
    }

    public void print(boolean[][] puts){
        for(int i=0;i<puts.length;i++){
            for(int j=0;j<puts.length;j++)
                System.out.print((puts[i][j]?"1":"0")+" ");
            System.out.println();
        }
        System.out.println("\n");

    }
}
