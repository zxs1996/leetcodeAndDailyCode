package 力扣_more_1000;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;
import javafx.scene.effect.SepiaTone;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zxs666
 * @date 2021/1/11 10:09
 */
public class Num_1202 {

    @Test
    public void test(){

    }


    public  String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] res = s.toCharArray();
        int n=s.length();
        UnionSearch us=new UnionSearch(n);
        for(List<Integer> list:pairs){
            us.join(list.get(0),list.get(1));
        }
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int father=us.unionSearch(i);
            Set<Integer> set;
            if(map.containsKey(father))
                set=map.get(father);
            else
                set=new HashSet<>();
            set.add(i);
            map.put(father,set);
        }
        for(int key:map.keySet()){
            List<Integer> list=map.get(key).stream().collect(Collectors.toList());
            Collections.sort(list);
            char[] arr=new char[list.size()];
            for(int i=0;i<list.size();i++)
                arr[i]=res[list.get(i)];
            Arrays.sort(arr);
            for(int i=0;i<list.size();i++){
                res[list.get(i)]=arr[i];
            }
        }
        return new String(res);
    }

    class UnionSearch {

        int[] pre;

        public UnionSearch(int n) {
            pre = new int[n];
            for (int i = 0; i < n; i++)
                pre[i] = i;
        }

        public int unionSearch(int root) {
            int root2 = root;
            //一直往上找，直到找到他的最高领导人
            while (root != pre[root])
                root = pre[root];

            //路径压缩,将从root往上找这个过程中所有的元素都设为最高领导人直接管理，方便下次查询
            while (root2 != root) {
                int temp = pre[root2];//记录它的上级
                pre[root2] = root;//将当前元素直接设置为最高领导人管理
                root2 = temp;//对它之前的上级做相同操作
            }
            return root;
        }


        //合并
        public void join(int x, int y) {
            int root1 = unionSearch(x);
            int root2 = unionSearch(y);
            if (root1 != root2)
                pre[root1] = root2;
        }

    }
}
