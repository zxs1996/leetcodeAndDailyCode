package 力扣_401_500;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/11/4 9:21
 */
public class Num_406 {

    @Test
    public void test1() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        //System.out.println(Arrays.deepToString(people));
        reconstructQueue(people);
        // System.out.println(Arrays.deepToString(people));
    }

    public int[][] reconstructQueue(int[][] people) {
        //先按照k值升序排列  再按照身高降序排列，
        //这样排出来能保证数组是按照升高降序排列，相同身高按照k升序排列
        //每次处理的时候当前元素的身高一定是比前面人的身高低或者相等的，我们直接按照他的k值插入排序就好了，
        Arrays.sort(people, Comparator.comparingInt(o -> o[1]));

        Arrays.sort(people, Comparator.comparingInt(o -> -o[0]));
        List<int[]> list = new LinkedList<>();
        for (int[] nums : people)
            list.add(nums[1], nums);

        people = list.toArray(people);
        System.out.println(Arrays.deepToString(people));
        return people;
    }

}
