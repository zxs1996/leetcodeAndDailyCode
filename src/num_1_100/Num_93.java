package num_1_100;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zxs666 on 2020/7/18.
 */
public class Num_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recurse(s, 0, 0, new ArrayDeque<>(), res);
        return res;
    }

    public void recurse(String s, int start, int count, ArrayDeque<String> queue, List<String> res) {
        //如果超过了边界，那么返回
        if (start > s.length())
            return;
        //如果count=4,那么达到临界点
        if (count == 4) {
            //如果s数组没有全部使用完
            if (start != s.length())
                return;
            StringBuffer sb = new StringBuffer("");
            for (String str : queue)
                sb.append(str + ".");
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }

        for (int i = start + 1; i <= s.length() && i <= start + 3; i++) {
            String str = s.substring(start, i);
            if (str.length() >= 2 && str.startsWith("0"))
                return;
            int num = Integer.valueOf(str);
            if (num > 255)
                break;
            queue.addLast(str);
            recurse(s, i, count + 1, queue, res);
            queue.removeLast();
        }
    }

    @Test
    public void test1() {
        String s = "1111";
        List<String> res = restoreIpAddresses(s);
        for (String str : res)
            System.out.println(str);
    }
}
