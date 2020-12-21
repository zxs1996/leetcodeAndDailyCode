package 力扣_901_1000;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/11/2 16:09
 */
public class Num_978 {

    @Test
    public void test() {
        int[] A = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        int res = maxTurbulenceSize2(A);
        System.out.println(res);
    }


    //滑动窗口，记录当前的湍流数组的开始和结束下标
    public int maxTurbulenceSize2(int[] A) {
        int n = A.length;
        if (n == 0)
            return 0;
        int res = 1;
        int start = 0, end = 0;
        for (int i = 1; i < n; i++) {
            //如果前面窗口大小为1
            if (i == start + 1) {
                if (A[i] != A[i - 1])
                    end++;
                else
                    start = end = i;
            }
            //否则窗口不为1
            else {
                if (A[i] > A[i - 1] && A[i - 1] < A[i - 2])
                    end++;
                else if (A[i] < A[i - 1] && A[i - 1] > A[i - 2])
                    end++;
                else {
                    if (A[i] == A[i - 1])
                        start = end = i;
                    else {
                        start = i - 1;
                        end = i;
                    }
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
