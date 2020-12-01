package num_1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/17.
 * 找规律的题，每增加一位，是在前一位的基础上最高位分别添1和添加0，
 */
public class Num_89 {

    public static void main(String[] args) {
        new  Num_89().grayCode(6);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        int size=res.size();
        for (int i = 0; i < n; i++) {
            for (int j = size-1; j >=0; j--)
                res.add(res.get(j) + head);
            head = head << 1;//左移一位
        }
        return res;

    }
}
