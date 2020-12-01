package num_201_300;

import org.junit.Test;

import javax.xml.transform.Source;
import java.lang.reflect.Array;
import java.util.*;

//使用优先队列实现
 class Ugly {
    long nums[] = new long[1690];

    public Ugly() {
        //优先级队列，也就是小根堆
        PriorityQueue<Long> queue = new PriorityQueue<>();
        //Set 去重
        Set<Long> set = new HashSet<>();
        queue.add(1l);
        for (int i = 0; i < 1690; i++) {
            long num = queue.poll();
            //System.out.print(num+" ");
            nums[i] = num;
            long res = num * 2;
            if (!set.contains(res)) {
                queue.offer(res);
                set.add(res);
            }

            res = num * 3;
            if (!set.contains(res)) {
                queue.offer(res);
                set.add(res);
            }

            res = num * 5;
            if (!set.contains(res)) {
                queue.offer(res);
                set.add(res);
            }

        }
    }
}
//使用三指针
class Ugly2 {
    int nums[] = new int[1690];

    public Ugly2() {
        Set<Integer> set=new HashSet<>();
        nums[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < 1690; i++) {
            //取当前最小值
            int num = Math.min(Math.min(nums[p2] * 2, nums[p3] * 3), nums[p5] * 5);
            nums[i] = num;
            //将取过的值 下标++
            //注意这里使用if 不用else if 因为如果 3*2 和2*3 得到的都是6，那么p2和p3都要++
            if (num == nums[p2] * 2) p2++;
            if (num == nums[p3] * 3) p3++;
            if (num == nums[p5] * 5)  p5++;
        }
    }
}

public class Num_264 {

     public static Ugly2 u=new Ugly2();//将ugly开成静态成员变量，那么可以很大程度的减少运行时间
    public int nthUglyNumber(int n) {
       return u.nums[n-1];
    }


}
