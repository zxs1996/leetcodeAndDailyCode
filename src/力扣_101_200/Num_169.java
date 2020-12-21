package 力扣_101_200;

import java.util.*;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_169 {


    //用空间map换时间
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.replace(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        Integer res = null;
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (res == null) {
                res = key;
                continue;
            }

            if (map.get(key) > map.get(res))
                res = key;
        }
        return res;
    }


    //不适用额外空间，高效算法
    public int majorityElement2(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //如果当前值不等于res，那么计数减一个
            if (nums[i] != res)
                count--;
            else
                count++;
            //如果计数值减为0，那么res刷新
            if (count == 0) {
                count = 1;
                res = nums[i];
            }
        }
        return res;

    }

}
