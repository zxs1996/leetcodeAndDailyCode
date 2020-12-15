package num_701_800;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author zxs666
 * @date 2020/12/8 14:20
 */
public class Num_842 {

    @Test
    public void test() {
        String s = "123456579";
        List<Integer> res = splitIntoFibonacci(s);
        System.out.println(res);
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        recurse(res, 0, S);
        return res.size() > 2 ? res : new ArrayList<>();
    }

    public boolean recurse(List<Integer> list, int index, String s) {
        //如果到达边界
        if (index >= s.length()){
            if(list.size()>=3)
            return true;
            else return false;
        }


        //注意不能越界
        for (int i = 1; i < 12 && i + index <= s.length(); i++) {

            String str = s.substring(index, index + i);

            //如果是0开头
            if (str.charAt(0) == '0' && str.length() > 1)
                break;
            long cur = Long.valueOf(str);
            if (cur > Integer.MAX_VALUE)
                break;
            int listSize = list.size();
            if (listSize >= 2) {
                if (list.get(listSize - 1) + list.get(listSize - 2) > cur)
                    continue;
                else if (list.get(listSize - 1) + list.get(listSize - 2) < cur)
                    break;
            }
            list.add((int) cur);
            boolean res = recurse(list, index + i, s);
            if (res)
                return true;
            list.remove(list.size() - 1);
        }
        return false;
    }
}
