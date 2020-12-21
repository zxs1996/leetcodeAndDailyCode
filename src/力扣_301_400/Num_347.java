package 力扣_301_400;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/17 15:01
 */
public class Num_347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        //先试用一个map记录每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //用一个优先队列,里面放键值对key是出现的次数，value是对应值
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p.getKey()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Pair<Integer, Integer> p = new Pair(entry.getValue(), entry.getKey());
            pq.add(p);
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getValue();
        }
        return res;

    }

    @Test
    public void test1(){
        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>(Comparator.comparingInt(p->p.getKey()));
        Pair<Integer,Integer> p1=new Pair<>(1,2);
        Pair<Integer,Integer> p2=new Pair<>(1,2);
        pq.add(p1);
        pq.add(p2);
        while(pq.size()>0){
            Pair<Integer,Integer> p=pq.poll();
            System.out.println(p.getKey()+"--"+p.getValue());
        }

    }
}
