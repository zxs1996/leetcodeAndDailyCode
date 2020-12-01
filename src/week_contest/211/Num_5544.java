import org.junit.Test;

import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/10/18 11:49
 */
public class Num_5544 {

    @Test
    public void test1() {
        String res = findLexSmallestString("43987654", 7, 3);
        System.out.println(res);
    }

    public String findLexSmallestString(String s, int a, int b) {
        String res = s;
        char[] arr = s.toCharArray();
        int n = res.length();
        int start = 0;
        Map<Integer, Boolean> map = new HashMap<>();

        //外层轮转
        while (true) {
            System.out.print("\nstart" + start + ":  ");
            if (map.containsKey(start))
                break;
            map.put(start, true);
            //内层累加，直到加过的元素
            for (int k = 0; k < 10; k++) {
                String str = new String(arr).substring(start, n) + new String(arr).substring(0, start);
                System.out.print(str + "  ");
                res = res.compareTo(str) < 0 ? res : str;
                int index = start % 2 == 1 ? start : (start + 1) % n;
                for (int i = 0; i < n / 2; i++) {
                    //转换成int，加a模10以后再转回char
                    arr[index] = (char) ((((int) arr[index] - (int) '0' + a) % 10) + (int) '0');
                    index = (index + 2) % n;
                }
            }
            //轮转
            start = (start + b) % n;
        }
        return res;
    }
}
