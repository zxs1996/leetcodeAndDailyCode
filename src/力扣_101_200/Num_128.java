package 力扣_101_200;

import org.junit.Before;
import org.junit.Test;

import java.rmi.ConnectIOException;
import java.util.*;

/**
 * Created by zxs666 on 2020/7/20.
 * 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 * 利用treeMap排序，然后遍历一次key
 */
public class Num_128 {
    @Test
    public void test() {


        int nums[] = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int res = longestConsecutive2(nums);
        System.out.println(res);
    }


    //排序之后找时间复杂度O（NlogN)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int res = 1;
        int cur = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre)
                continue;
            else if (nums[i] == pre + 1) {
                cur++;
                pre = nums[i];
            } else {
                res = Math.max(res, cur);
                cur = 1;
                pre = nums[i];
            }
        }
        return Math.max(res, cur);

    }


    //使用Hash表
    public int longestConsecutive3(int[] nums) {
        Set<Integer> set = new HashSet();
        int res = 0;
        for (int num : nums)
            set.add(num);
        for (int num : nums) {
            //当它不包含一个数的时候，比如 5 2 3 1和5 4 3 1 2就不一样，第一个5可以直接算，因为它一定是起点，但是第二个5不是，它有前导4
            if (!set.contains(num - 1)) {
                int curNum = num;
                int count = 0;
                while (set.contains(curNum)) {
                    count++;
                    curNum++;
                }
                res = Math.max(res, count);
            }
        }
        return res;

    }


    //使用并查集 时间复杂度O(N)，但是效率并不高
    public int longestConsecutive2(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        MyUnionSearch us = new MyUnionSearch(n);
        //map记录每个元素的下标，例如 nums[3]=5，那么存<5,3>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]))
                continue;
            //看左右两边有没有相邻的，有的话并查集合并
            if (map.containsKey(nums[i] - 1))
                us.join(i, map.get(nums[i] - 1));
            if (map.containsKey(nums[i] + 1))
                us.join(i, map.get(nums[i] + 1));
            //记录在map中
            map.put(nums[i], i);
        }

        int res = 0;
        map.clear();
        for (int i = 0; i < n; i++) {
            int root = us.unionSearch(i);

            map.put(root, map.getOrDefault(root, 0) + 1);
        }
        for (int val : map.values())
            res = Math.max(res, val);
        return res;
    }


    //并查集
    private class MyUnionSearch {
        int[] pre;//pre[i]的值表示i的父节点下标

        public MyUnionSearch(int n) {
            pre = new int[n];
            for (int i = 0; i < n; i++)
                pre[i] = i;
        }

        public int unionSearch(int x) {
            int root = x;
            while (pre[root] != root)
                root = pre[root];
            while (x != root) {
                int temp = pre[x];
                pre[x] = root;
                x = temp;
            }
            return root;
        }


        public void join(int x, int y) {
            int root1 = unionSearch(x);
            int root2 = unionSearch(y);
            if (root1 != root2)
                pre[root1] = root2;
        }
    }
}
