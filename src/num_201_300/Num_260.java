package num_201_300;

import java.util.HashMap;
import java.util.Map;

public class Num_260 {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.remove(nums[i]);
            else
                map.put(nums[i], 1);
        }
        int index = 0;
        for (int key : map.keySet())
            res[index++] = key;
        return res;

    }
}
