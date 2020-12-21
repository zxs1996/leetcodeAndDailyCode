package 力扣_1_100;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/11/7 21:18
 *
 * 结合95题来看
 */
public class Num_96 {
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0]=1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum=sum+count[j-1]*count[i-j];
            }
            count[i]=sum;
        }
        /*for(int i=1;i<=n;i++)
            System.out.print(count[i]+" ");*/
        return count[n];
    }

    @Test
    public void test1(){
        int res=numTrees(3);
        System.out.println();
    }
}
