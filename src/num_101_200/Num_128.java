package num_101_200;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by zxs666 on 2020/7/20.
 * 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 * 利用treeMap排序，然后遍历一次key
 */
public class Num_128 {
    public static void main(String[] args) {
        int nums[]={0,-1};
        int res=new Num_128().longestConsecutive(nums);
        System.out.println(res);
    }
    public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0)
        return 0;

    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < nums.length; i++)
        map.put(nums[i], 1);
    Set<Integer> set = map.keySet();
    for(Integer key:set)
        System.out.print(key+"  ");
    Object[] arr =  set.toArray();
    int max = 1;
    int count = 1;
    for (int i = 1; i < arr.length; i++) {
        System.out.println((int)arr[i] == (int)arr[i - 1] + 1);
        if ((int)arr[i] == (int)arr[i - 1] + 1)
            count++;
        else {
            max = Math.max(max, count);
            count = 1;
        }
    }
    return Math.max(max,count);
}
}
