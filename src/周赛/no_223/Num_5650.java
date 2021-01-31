package 周赛.no_223;

import java.util.*;

/**
 * @author zxs666
 * @date 2021/1/10 11:22
 */
public class Num_5650 {

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;
        UnionSearch us = new UnionSearch(n);
        for (int i = 0; i < allowedSwaps.length; i++)
            us.join(allowedSwaps[i][0], allowedSwaps[i][1]);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int father = us.unionSearch(i);
            Set<Integer> set;
            if (map.containsKey(father))
                set = map.get(father);
            else
                set = new HashSet<>();
            set.add(i);
            map.put(father, set);
        }
        Map<Integer, Integer> countMap = new HashMap<>();

        int res = 0;
        for (int key : map.keySet()) {
            Set<Integer> set = map.get(key);
            System.out.println(set);
            for (int location : set) {
                int num1 = source[location];
                int num2 = target[location];
                countMap.put(num1, countMap.getOrDefault(num1, 0) + 1);
                countMap.put(num2, countMap.getOrDefault(num2, 0) - 1);
            }
            System.out.println(countMap);
            for (int num : countMap.keySet()) {
                res += Math.abs(countMap.get(num));
            }
            countMap.clear();;
        }

        return res/2;

    }


    class UnionSearch {

        int[] pre;

        public UnionSearch(int n) {
            pre = new int[n];
            for (int i = 0; i < n; i++)
                pre[i] = i;
        }

        public int unionSearch(int root) {
            int root2 = root;
            //一直往上找，直到找到他的最高领导人
            while (root != pre[root])
                root = pre[root];

            //路径压缩,将从root往上找这个过程中所有的元素都设为最高领导人直接管理，方便下次查询
            while (root2 != root) {
                int temp = pre[root2];//记录它的上级
                pre[root2] = root;//将当前元素直接设置为最高领导人管理
                root2 = temp;//对它之前的上级做相同操作
            }
            return root;
        }


        //合并
        public void join(int x, int y) {
            int root1 = unionSearch(x);
            int root2 = unionSearch(y);
            if (root1 != root2)
                pre[root1] = root2;
        }

    }
}
