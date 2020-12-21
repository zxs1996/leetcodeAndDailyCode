package 力扣_101_200;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num_137 {
    public int singleNumber(int[] nums) {
        //使用map记录每个数字出现的次数。
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.replace(nums[i], 3);
            else
                map.put(nums[i],1);
        }
        Set<Integer> set=map.keySet();
        for (int key:set) {
            if(map.get(key)==1)
                return key;
        }
        return 0;
    }
}
