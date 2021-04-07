package 剑指offer;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2021/3/13 11:38
 */
public class Num_38_2 {


    List<String> list = new ArrayList();
    char[] strs;
    char[] arr;
    boolean[] visted;

    public String[] permutation(String s) {

        strs = s.toCharArray();
        arr = new char[strs.length];
        visted = new boolean[strs.length];
        Arrays.sort(strs);
        recurse(0);
        String[] res = new String[list.size()];
        res = list.toArray(res);
        return res;
    }

    public void recurse(int index) {
        if (index == strs.length) {
            list.add(new String(arr));
            return;
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (!visted[i]) {
                    //去重，如果前一个字符和当前字符相同，并且前一个字符没有选，那么continue
                    if (i > 0 && strs[i] == strs[i - 1]&&!visted[i-1])
                        continue;
                    visted[i]=true;
                    arr[index] = strs[i];
                    recurse(index + 1);
                    visted[i]=false;
                }

            }

        }
    }
    @Test
    public void test(){
        String s="abc";
        String[] res=permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
