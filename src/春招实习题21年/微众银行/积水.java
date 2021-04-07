package 春招实习题21年.微众银行;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.*;

/**
 * @author zxs666
 * @date 2021/4/6 18:57
 */
public class 积水 {

   /*
 5
2 2 3 2 3

    */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] water = new int[n];
        for (int i = 0; i < n; i++)
            water[i] = scanner.nextInt();
        String[] res = new String[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        UnionSearch us = new UnionSearch(n);
        for (int i = 0; i < m; i++) {
            int x1 = scanner.nextInt() - 1;
            int x2 = scanner.nextInt() - 1;
            int x1Search = us.unionSearch(x1);
            int x2Search = us.unionSearch(x2);
            if (x1Search != x2Search)
                us.join(x1Search, x2Search);
        }
        for (int i = 0; i < n; i++) {
            int root = us.unionSearch(i);
            List<Integer> list;
            if (map.containsKey(root))
                map.get(root).add(i);
            else {
                list = new ArrayList<>();
                list.add(i);
                map.put(root, list);
            }
        }

        System.out.println(map);
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            double sum = 0;
            for (int num : list)
                sum += water[num];
            String avg = getliangwei(sum / list.size());
            for (int num : list)
                res[num] = avg;
        }

        for (String num : res)
            System.out.print(num + " ");

    }


    static class UnionSearch {

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




    @Test
    public void test(){
        double res=0;
        for(int i=0;i<100000;i++)
            res+=1000000;

        String number=getliangwei(res);
        System.out.println(number);
    }
    public static String getliangwei(double x) {

        BigDecimal value = new BigDecimal(x + "");
        String res = value.setScale(2, RoundingMode.HALF_UP).toString();

        int index = res.indexOf(".");
        if (index == res.length() - 1) {
            res += "00";
        } else if (index == res.length() - 2)
            res += "0";
        return res;
    }

    public static String getTwo(double x) {
        //后面加3位小数
        String str = x + "000";
        int index = str.indexOf(".");
        double res = Double.parseDouble(str.substring(0, index + 3));
        char c = str.charAt(index + 3);
        if (c > '4')
            res += 0.01;
        str = res + "";
        index = str.indexOf(".");
     return null;
    }
}
