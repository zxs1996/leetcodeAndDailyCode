package interview_problem;

import java.util.*;

/**
 * Created by zxs666 on 2020/7/8.
 */
public class Num16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        list.add(shorter * k);
        for (int i = 1; i <= k; i++) {
            int sum = i*longer  + (k - i) * shorter;
            if (sum != list.get(list.size() - 1))
                list.add(sum);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
