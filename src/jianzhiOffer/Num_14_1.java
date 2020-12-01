package jianzhiOffer;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/11/16 21:11
 */
public class Num_14_1 {


    @Test
    public void test() {

        int n=-3;
        String s=Integer.toBinaryString(n);
        System.out.println(s);
        System.out.println(cuttingRope(120));
    }


    @Test
    public void test2() {

        int[][]nums=new int[2][5];
        Integer[] nums2=new Integer[2];

        int n=-3;

        Arrays.sort(nums, (o1, o2) -> 0);
        Arrays.sort(nums, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        List<int[]> list=new ArrayList<>();
        for(int[] num:nums)
            list.add(num[1],num);

         nums=list.toArray(nums);

    }

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long res = 1L;
        int p = (int) 1e9 + 7;
        //贪心算法，优先切三，其次切二
        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }
        int num[] = new int[3];
        //出来循环只有三种情况，分别是n=2、3、4
        return (int) (res * n % p);
    }
}
