package num_more_1000;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/11/10 12:00
 * <p>
 * //贪心算法，每次选择当前剩余最大的字符来填充
 */
public class Num_1405 {

    @Test
    public void test() {
        String res = longestDiverseString(7, 1, 0);
        System.out.println(res);
    }

    public String longestDiverseString(int a, int b, int c) {
        int[][] arr = {{a, 0}, {b, 1}, {c, 2}};

        boolean flag = true;
        System.out.println(Arrays.deepToString(arr));
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; flag && i < a + b + c; i++) {
            flag = false;
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
            char prefix = '0';

            //先找前面两个重复的字符，如果不存在或者不重复，那么初始为‘0’
            if (sb.length() >= 2 && sb.charAt(i - 1) == sb.charAt(i - 2))
                prefix = sb.charAt(i - 1);
            //找当前剩余最多的字符，如果和前缀字符不相等，那么添加一个
            for (int j = 2; j >= 0; j--) {
                if (arr[j][0] > 0 && (char) (arr[j][1] + 'a') != prefix) {
                    sb.append((char) (arr[j][1] + 'a'));
                    arr[j][0]--;
                    flag = true;
                    break;
                }
            }
        }

        return sb.toString();
    }

}
