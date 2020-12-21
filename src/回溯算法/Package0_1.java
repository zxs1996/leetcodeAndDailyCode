package 回溯算法;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/19 18:46
 */
public class Package0_1 {

    int bestV = 0;
    int w[];
    int v[];
    int n;

    public void knapBacktrack(int i, int cv, int c) {
        if (i == n) {
            bestV = Math.max(bestV, cv);
            return;
        }
        //计算左子树最优值上界，
        int leftMax = 0;
        for (int j = i; j < n; j++)
            leftMax += v[i];
        //如果左子树上界+cv小于当前最优值的话，那么剪掉，直接返回
        if (cv + leftMax <= bestV)
            return;
        //去左子树
        if (c >= w[i]) {
            knapBacktrack(i + 1, cv + v[i], c - w[i]);
        }
        knapBacktrack(i + 1, cv, c);
    }

    @Test
    public void test(){
        w=new int[]{2,3,4};
        v=new int[]{2,3,4};
        n=3;
        int c=6;
        knapBacktrack(0,0,c);
        System.out.println(bestV);

    }
}
