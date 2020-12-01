package algCourse.test;

import org.junit.Test;
import redblackTree.RedBlackTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zxs666
 * @date 2020/11/4 16:56
 */
public class RBT_Test {

    @Test
    public void test() {
        Random random = new Random();
        RedBlackTree rbt = new RedBlackTree();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            int num;
            while (map.containsKey(num = random.nextInt(100))) ;
            map.put(num, 1);
           // System.out.print(num + " ");
            rbt.RBInsert(num);
        }
        rbt.RBShow();
        System.out.println();
        for(int i=0;i<10;i++){
            int num=random.nextInt(100);
            System.out.println(num+" "+ rbt.RBSearch(num));
        }


    }

    @Test
    public void test2() {
        RedBlackTree rbt = new RedBlackTree();
        for (int i = 1; i < 10; i++){
            rbt.RBInsert(i);
        }
        rbt.RBShow();
    }
}
