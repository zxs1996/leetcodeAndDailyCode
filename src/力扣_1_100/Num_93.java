package 力扣_1_100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/18.
 */
public class Num_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        String[] strs = new String[4];
        recurse(s, 0, 0, strs, res);
        return res;
    }

    public void recurse(String s, int start, int count, String[] strs, List<String> res) {
        //如果超过了边界，那么返回
        if (start > s.length())
            return;
        //如果count=4,那么ip地址的4个位置都放了数字
        if (count == 4) {
            //如果s刚好使用完
            if (start == s.length()) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 4; i++) {
                    sb.append(strs[i]);
                    sb.append(".");
                }
                //注意要把最后的点去掉
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        for (int i = start + 1; i <= s.length() && i <= start + 3; i++) {
            String str = s.substring(start, i);
            //如果存在前导0，那么往后都会前导0，直接break
            if (str.length() >= 2 && str.startsWith("0"))
                break;
            int num = Integer.valueOf(str);
            if (num > 255)
                break;
            strs[count] = str;
            recurse(s, i, count + 1, strs, res);
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
