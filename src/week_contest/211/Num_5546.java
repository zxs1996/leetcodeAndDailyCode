import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxs666
 * @date 2020/10/18 11:29
 */
public class Num_5546 {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int maxGcd = 0;
            if (queries[i][0] < queries[i][1])
                maxGcd = gcd_1(queries[i][1], queries[i][0]);
            else
                maxGcd = gcd_1(queries[i][0], queries[i][1]);
            if (maxGcd > threshold)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }



    @Test
    public void test(){
        for(int i=1;i<20;i++)
            for(int j=1;j<20;j++)
                System.out.println(i+"-"+j+":"+gcd_1(i,j));
    }
    int gcd_1(int a, int b) {
        return b == 0 ? a : gcd_1(b, a % b);
    }
}
