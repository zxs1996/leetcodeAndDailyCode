package 力扣_301_400;

import javafx.util.Pair;
import org.junit.Test;

import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @author zxs666
 * @date 2021/1/6 15:41
 * 计算两点之间的是否有路径到达
 */
public class Num_399 {
    private class Pair {
        String s1;
        String s2;

        public Pair(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return s1.equals(pair.s1) &&
                    s2.equals(pair.s2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s1, s2);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "s1='" + s1 + '\'' +
                    ", s2='" + s2 + '\'' +
                    '}';
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //保存结果,记录每个除法的结果
        Map<Pair, Double> map = new HashMap();
        //记录有多少种变量(字符串)
        Set<String> set = new HashSet<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String str1 = equation.get(0);
            String str2 = equation.get(1);
            set.add(str1);
            set.add(str2);
            map.put(new Pair(str1, str1), 1.0);
            map.put(new Pair(str2, str2), 1.0);
            putMap(map, str1, str2, values[i]);
        }
        String[] arr = new String[set.size()];
        arr = set.toArray(arr);

        //floyd算法，三层for循环
        //通过第k个点中转
        for (int k = 0; k < arr.length; k++)
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr.length; j++) {
                    if (i == j || i == k || j == k)
                        continue;
                    if (map.containsKey(new Pair(arr[i], arr[j])))
                        continue;
                    Pair p1 = new Pair(arr[i], arr[k]);
                    Pair p2 = new Pair(arr[k], arr[j]);

                    if (map.containsKey(p1) && map.containsKey(p2)) {
                        putMap(map, arr[i], arr[j], map.get(p1) * map.get(p2));
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k] + "---" + map.get(p1) + ",, " + map.get(p2));

                    }
                }
        System.out.println(set);

        System.out.println(map);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);
            res[i] = getMap(map, str1, str2);
        }
        return res;
    }

    public void putMap(Map<Pair, Double> map, String str1, String str2, double value) {
        if (str1.compareTo(str2) <= 0)
            map.put(new Pair(str1, str2), value);
        else
            map.put(new Pair(str2, str1), 1 / value);
    }

    public double getMap(Map<Pair, Double> map, String str1, String str2) {
        Pair p1 = new Pair(str1, str2);
        Pair p2 = new Pair(str2, str1);
        if (str1 == str2)
            return 1;
        if (map.containsKey(p1) || map.containsKey(p2)) {
            if (str1.compareTo(str2) <=  0)
                return map.get(p1);
            else
                return map.get(p2);
        }
        return -1;


    }

    @Test
    public void test() {
        String[] str1 = {"zxs", "abs"};
        String[] str2 = {"zxs", "abs"};
        Set<String[]> set = new HashSet<>();
        set.add(str1);
        set.add(str2);
        System.out.println(set.size());
    }


}
