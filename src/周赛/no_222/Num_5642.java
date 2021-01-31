import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2021/1/3 10:39
 */
public class Num_5642 {
    public int countPairs(int[] deliciousness) {

        double res = 0;
        int MOD = 1000000000 + 7;
        int[] arr = new int[32];
        for (int i = 0; i <= 31; i++)
            arr[i] = (int) Math.pow(2, i);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deliciousness)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (int num : deliciousness) {
            for (int i = 0; i < arr.length; i++) {
                int need = arr[i] - num;
                if(map.containsKey(need)){
                    int count = map.get(need);
                    if (need == num)
                        count--;
                    res += count/2.0;
                    res %= MOD;
                }
            }
        }
        return (int)res ;
    }

    @Test
    public void test2(){
        int[] num={1,3,5,7,9};
        System.out.println(countPairs(num));
    }


    @Test
    public void test() {
        int MOD = 1000000000 + 7;
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(1000000000);
            System.out.println(num % MOD == (num * 2) % (MOD * 2) / 2);
        }
    }
}
