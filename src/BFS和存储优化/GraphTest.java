package BFS和存储优化;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zxs666
 * @date 2021/1/11 14:40
 */
public class GraphTest {

    @Test
    public void test() {
      /* A B C D E F G
       A-B
        A-C
        C-D
        C-E
        D-E
        F-G*/
        List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E','F','G','H');
        char[][] edgeInfo = {{'A', 'B'}, {'A','C' },{'C','D'},{'C', 'E'} , {'D', 'E'},{'F','G'}};
        Graph graph = new Graph();
        graph.createGraph(list, edgeInfo);
        //graph.print();
        System.out.println(graph.bfs());
      /*  for(int i=0;i<5;i++){
            System.out.println(i+"  ");
            graph.showILink(i);
        }*/

    }
}
