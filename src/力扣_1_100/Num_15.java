package 力扣_1_100;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/5.
 */
public class Num_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        if (n < 3)
            return list;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            //最左值为正数，直接跳出。
            if (nums[i] > 0)
                break;

            //当前值和前一个值相同，避免重复list，直接进入下一轮
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            //最小值都比0大，直接break
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0)
                break;
            //最大值比0小，continue
            if (nums[i] + nums[n - 1] + nums[n - 2] < 0)
                continue;
            int j = i + 1, k = n - 1;
            int value = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == value) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //循环去重
                    while (++j < k && nums[j] == nums[j - 1]) ;
                    while (j < --k && nums[k] == nums[k + 1]) ;
                }
                //大于0，往左走，走到第一个不相等的数
                else if (nums[j] + nums[k] > value)
                    --k;
                    //小于0，往右走，走到第一个不相等的数
                else
                    ++j;
            }
        }
        return list;
    }


    //使用hashMap
    public List<List<Integer>> threeSum2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        if (nums == null || nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0)
            return list;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                int needValue = 0 - nums[i] - nums[j];
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if (map.containsKey(needValue) && map.get(needValue) > j) {
                    list.add(Arrays.asList(nums[i], nums[j], needValue));
                }
            }
        }

        return list;
    }

    //不适用hashMap，从两端渐进

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0)
            return list;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = nums.length - 1;
            int needValue = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == needValue) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //一直找到不等于当前j的值
                    while (++j < k && nums[j] == nums[j - 1]) ;

                    //一直找到不等于当前k的值
                    while (--k > j && nums[k] == nums[k + 1]) ;
                } else if (nums[j] + nums[k] > needValue)
                    k--;
                else
                    j++;
            }
        }
        return list;
    }
}