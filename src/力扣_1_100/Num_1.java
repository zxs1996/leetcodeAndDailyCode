package 力扣_1_100;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2021/1/29 14:28
 * 两种解法
 * 第一种二重循环暴力
 * 第二种 使用hash表，注意hash表使用的时候，要先判断有没有target-nums[i]，然后在放入。防止错误
 *
 */
public class Num_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return null;

    }

    @Test
    public void test() {
        Map<Integer, List<Integer>> map = new HashMap();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        map.put(1, list);
        List<Integer> list22 = map.get(1);
        System.out.println(list instanceof ArrayList);
        list22.add(42);
        System.out.println(map);
    }
}
