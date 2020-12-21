package 周赛.Num_198;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num5465_treelable {
    public static void main(String[] args) {
        List list=new ArrayList<>(1);

    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[]  res= new int[n];
        boolean[] flag=new boolean[n];
        Arrays.fill(flag,false);
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                List<Integer> list = map.get(edges[i][0]);
                list.add(edges[i][1]);
                map.replace(edges[i][0], list);
            } else{
                List list=new ArrayList();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            }

        }
        Set<Integer> set=map.keySet();
        for (Integer key:set) {
            System.out.println(key+","+Arrays.toString(map.get(key).toArray()));
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char key = labels.charAt(i);
            int count = 0;
            queue.offer(i);
            while (queue.size() > 0) {
                int num = queue.poll();
                if (labels.charAt(num) == key)
                    count++;
                List<Integer> list = map.get(num);
                if(list==null)
                    continue;
                for (int tempI : list)
                    queue.offer(tempI);
            }
            res[i] = count;
        }
        return res;

    }

}
