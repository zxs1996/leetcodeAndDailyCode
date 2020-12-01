package sorts.countSort;

import com.sun.corba.se.impl.naming.namingutil.CorbalocURL;
import org.junit.Test;

import javax.xml.stream.events.DTD;
import java.util.Arrays;
import java.util.Currency;
import java.util.Random;

/**
 * @author zxs666
 * @date 2020/10/29 14:07
 */
public class CountSort {

    @Test
    public void test() {
        int n = 20000000;
        int max=3000000;
        Random random = new Random();
        int[] source = new int[n];
        for (int i = 0; i < n; i++)
            source[i] = random.nextInt(max);
        int[] target = new int[n];
        long start=System.currentTimeMillis();
        countSort(source, target, max);
        long end=System.currentTimeMillis();
        System.out.println("老师那种方法:"+(end-start));

        start=System.currentTimeMillis();
        countSort2(source,max);
        end=System.currentTimeMillis();
        System.out.println("自己的方法:"+(end-start));

      /*  System.out.println(Arrays.toString(source));
        System.out.println(Arrays.toString(target));*/

    }

    public void countSort(int[] source, int[] target, int k) {
        int[] count = new int[k + 1];
        for (int i = 0; i < source.length; i++)
            count[source[i]]++;
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];
        for (int i = source.length - 1; i >= 0; i--) {
            target[count[source[i]] - 1] = source[i];
            count[source[i]]--;
        }
    }

    public void countSort2(int[] source, int k) {
        int[] count = new int[k + 1];
        for (int i = 0; i < source.length; i++)
            count[source[i]]++;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++)
                source[index++] = i;
        }
    }
}
