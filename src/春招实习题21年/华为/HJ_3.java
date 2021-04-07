package 春招实习题21年.华为;


import 排序算法.quicksort.Test;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * @author zxs666
 * @date 2021/3/29 18:23
 */
public class HJ_3 {
    public static void test() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Set<Integer>> list = new ArrayList<>();
        int N;
        while (sc.hasNextInt()) {
            Set<Integer> set = new TreeSet<>();
            N = sc.nextInt();
            for (int i = 0; i < N; i++)
                set.add(sc.nextInt());
            list.add(set);
        }
        for (Set<Integer> set : list) {
            for (int num : set)
                System.out.println(num);
        }
    }


}
