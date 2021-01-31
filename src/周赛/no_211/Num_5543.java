import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/10/18 10:31
 */
public class Num_5543 {

    public int maxLengthBetweenEqualCharacters(String s) {

        int res = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                res = Math.max(res, i - map.get(c) - 1);
            } else
                map.put(c, i);
        }
        return res;
    }
}
