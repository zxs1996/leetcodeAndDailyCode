package 力扣_201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = map.get(nums[i]);
                for (Integer index : list) {
                    if (Math.abs(index - i) <= k)
                        return true;
                }
                list.add(i);
            }
        }
        return false;
    }
}
