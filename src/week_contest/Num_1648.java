package week_contest;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/5 12:58
 */
public class Num_1648 {


    @Test
    public void test2() {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> -o));
        map.put(1, 1);
        map.put(2, 2);
        map.put(123, 13);
        map.put(123, 15);
        map.put(13, 13);
        for (Integer key : map.keySet())
            System.out.println(key + "," + map.get(key));
    }

    @Test
    public void tes() {
        int[] inventory = {2,8,4,10,6};
        int res = maxProfit(inventory, 20);
        System.out.println(res);
    }

    public int maxProfit(int[] inventory, int orders) {

        //[5,2]表示个数为5的球有两种
        Map<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> -o));
        for (int num : inventory)
            map.put(num, map.getOrDefault(num, 0) + 1);

        long MOD = 1000000007;
        long res = 0;
        while (orders > 0) {
            //如果所有球的个数都一样了,那么直接在这上面讨论
            if (map.size() == 1) {
                int key = 0, value;
                for (int tmp : map.keySet())
                    key = tmp;
                value = map.get(key);
                //System.out.println("getin ：key:" + key + ",value:" + value + "res:" + res);
                int times = orders / value;
                res = (res + (long)(key + key - times + 1) * times * value / 2 )%MOD ;
                orders = orders % value;
                res = (res + (key - times) * orders) % MOD;

                break;
            }

            //至少有两类
            else {
                int temp = 0;
                Map.Entry<Integer, Integer>[] entries = new Map.Entry[2];
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    entries[temp] = entry;
                    if (++temp == 2)
                        break;
                }
                long maxKey = entries[0].getKey();
                long maxValue = entries[0].getValue();
                long secondKey = entries[1].getKey();
                long secondValue = entries[1].getValue();
                //System.out.println("maxKey:"+maxKey+",maxValue:"+maxValue);
                //System.out.println("secondKey:"+secondKey+",secondValue:"+secondValue);
                long count = (maxKey - secondKey) * maxValue;
                //System.out.println("count:"+count);
                //如果不能消耗完orders
                if (orders >= count) {
                   // System.out.println("get orders");
                    res = (res +(long) (maxKey + secondKey + 1) * (maxKey - secondKey) * maxValue / 2) % MOD;
                   // System.out.println("res:"+res);
                    orders -= count;
                    map.remove((int)maxKey);
                    map.put((int)secondKey, (int)(secondValue + maxValue));
                }
                //能消耗完orders
                else {
                    long times = orders / maxValue;
                    res = (res + (maxKey + maxKey - times + 1) * times * maxValue / 2 % MOD) % MOD;
                    orders =(int)( orders % maxValue);
                    res = (res + (maxKey - times) * orders) % MOD;
                    break;
                }
            }
        }
        return (int)res;
    }
}
