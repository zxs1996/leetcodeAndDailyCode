package 力扣_201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_217 {
    public static void main(String[] args) {
        System.out.println(5 ^ 7);
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return true;
            map.put(nums[i], 1);
        }
        return false;
    }
}
