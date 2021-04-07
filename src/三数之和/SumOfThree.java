package 三数之和;

import com.sun.org.apache.regexp.internal.REUtil;
import javafx.util.Pair;
import org.junit.Test;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author zxs666
 * @date 2021/3/20 16:44
 */
public class SumOfThree {

    public List<List<Integer>> sumOfThree(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1, k = arr.length - 1;
            int need = -arr[i];
            while (j < k) {
                if (arr[j] + arr[k] == need) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[k]);
                    temp.add(arr[j]);
                    temp.add(arr[i]);
                    res.add(temp);
                    j++;
                    k--;
                    while (j < k && arr[j - 1] == arr[j])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                } else if (arr[j] + arr[k] > need)
                    k--;
                else
                    j++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = ziji(arr);
        System.out.println(res);
    }


    //给出数组的无重复子集
    public List<List<Integer>> ziji(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= arr.length; i++) {
            recurse(arr, new ArrayDeque<>(), 0, 0, i, res);
        }
        return res;

    }

    public void recurse(int[] arr, ArrayDeque<Integer> path, int index, int count, int expect, List<List<Integer>> res) {
        if (count == expect) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index >= arr.length)
            return;
        //不选当前元素
        recurse(arr, path, index + 1, count, expect, res);

        //选择当前元素
        path.addLast(arr[index]);
        recurse(arr, path, index + 1, count + 1, expect, res);
        path.removeLast();
    }
}
