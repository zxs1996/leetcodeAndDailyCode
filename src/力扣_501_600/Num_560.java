package 力扣_501_600;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/12/19 14:40
 */
public class Num_560 {

    @Test
    public void test() {
        int[] nums = {1};
        System.out.println(subarraySum(nums, 0));
    }

    public int subarraySum(int[] nums, int k) {

        //map<a,b> 表示在当前，前缀和的a的数组有b个
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//前缀和为0的数组有1个，即啥都不选
        int sum = 0;//记录到当前为止的前缀和
        int res = 0;
        for (int num : nums) {
            sum += num;
            //先判断前面是不是子数组和为sum-k，如果有的话，将它的次数加到res上
            if (map.containsKey(sum - k))
                res += map.get(sum - k);
            //更新map要放在判断之后，不然的话，会得到错误的值
            //map记录之前的前缀和出现的次数，比如从当前的前缀和是100，k是50，如果前面元素的前缀和为50。我知道50的前缀和的数组的数量，那么res+上对应就好
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return res;
    }
}
