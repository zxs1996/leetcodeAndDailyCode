package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zxs666
 * @date 2020/12/22 14:54
 * 滑动窗口，当sum>target,左边缩短
 * 否则右边增长
 */
public class Num_57 {


    @Test
    public void test2() {
        int n = 10;
        int times = n >> 2;
        int ans=0;


    }

    @Test
    public void test() {
        int[][] res = findContinuousSequence(15);
        System.out.println(Arrays.deepToString(res));


    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList();

        int sum = 0;
        int start = 1;//起始的值
        for (int i = 1; i <= target / 2 + 1; i++) {
            sum += i;

            //当前和大于target，从前面开始减
            while (sum > target) {
                sum -= start++;
            }

            //如果相同，那么添加到list里面去
            if (sum == target) {
                int[] arr = new int[i - start + 1];
                for (int j = start; j <= i; j++)
                    arr[j - start] = j;
                list.add(arr);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
