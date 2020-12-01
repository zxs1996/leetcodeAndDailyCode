package duotai;

import com.sun.org.apache.bcel.internal.generic.POP2;
import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/1 20:45
 */
public class Test2 {

    @Test
    public void test() {
        Person p1 = new Student();
        Person p2 = new Teacher();
        p1.eat();
        p2.eat();


        Queue<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        q1.add(1);
        q2.add(2);
    }
}
