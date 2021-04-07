package 剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zxs666
 * @date 2021/3/13 11:19
 *
 * 通过swap  Set去重
 */
public class Num_38 {
    public String[] permutation(String s) {
        //set能够去重，防止重复元素
        Set<String> set = new HashSet();
        char[] strs = s.toCharArray();
        recurse(strs, 0, set, new char[strs.length]);
        String[] res = new String[set.size()];
        int i = 0;
        for (String str : set) {
            res[i++] = str;
        }

        return res;
    }

    public void recurse(char[] strs, int index, Set<String> set, char[] arr) {
        if (index == strs.length) {
            set.add(new String(arr));
            return;
        } else {
            for (int i = index; i < strs.length; i++) {
                swap(strs, i, index);
                arr[index] = strs[index];
                recurse(strs, index + 1, set, arr);
                swap(strs, i, index);

            }

        }
    }

    public void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
