package 中等难度题.Recall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zxs666 on 2019/12/27.
 */
public class AllArrange {


    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> list=new AllArrange().permute(nums);
        for (List<Integer> alist:list) {
            for (int a:alist) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
    List<List<Integer>> list = new ArrayList<>();
    Integer[] digits;
    int[] numbers;
    int[] flag;
    int max;

    public List<List<Integer>> permute(int[] nums) {
        max = nums.length;
        flag = new int[max];
        numbers = nums;
        digits = new Integer[max];
        for (int i = 0; i < max; i++)
            flag[i] = 0;
        backTrace(0);
        return list;
    }

    public void backTrace(int n) {
        if (n == max) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>(digits.length);
            Collections.addAll(arrayList, digits);
            list.add(arrayList);
            return;
        }
        for (int i = 0; i < max; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                digits[n] = numbers[i];
                backTrace(n + 1);
                flag[i] = 0;
            }
        }
    }

}
