package 力扣_101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/22.
 */
public class Num_131 {

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(str.substring(4, 4));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        repeat(s, res, new ArrayDeque<>());
        return res;

    }

    public void repeat(String s, List<List<String>> res, ArrayDeque<String> list) {
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            //如果是回文串
            if (isHuiwen(str)) {
                list.addLast(str);
                repeat(s.substring(i + 1, s.length()), res, list);
                list.removeLast();
            }
        }
    }

    public boolean isHuiwen(String s) {
        if (s == null || s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
