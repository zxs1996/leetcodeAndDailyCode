import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2020/12/26 22:31
 */
public class Num_5621 {

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int num : students)
            queue.add(num);
        Stack<Integer> stack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--)
            stack.push(sandwiches[i]);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int stu = queue.poll();
                if (stu == stack.peek())
                    stack.pop();
                else
                    queue.add(stu);
            }
            if (size == queue.size())
                return size;
        }
        return 0;

    }
}
