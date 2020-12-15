import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zxs666
 * @date 2020/12/4 18:05
 */
public class Num_1656 {

    @Test
    public void test(){
        OrderedStream os= new OrderedStream(5);
     os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }
    class OrderedStream {
        String[] strs;
        Integer ptr;

        public OrderedStream(int n) {
            strs = new String[n + 1];
            ptr=1;
        }

        public List<String> insert(int id, String value) {
            strs[id] = value;

            List<String> res = new ArrayList<>();

            while (ptr<strs.length&&strs[ptr] != null) {
                res.add(strs[ptr]);
                ptr ++;
            }

            System.out.println(res);
            return res;
        }
    }
}
