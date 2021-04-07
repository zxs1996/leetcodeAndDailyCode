package 春招实习题21年.美团;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author zxs666
 * @date 2021/4/4 10:14
 */
public class 不高兴和2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.clear();
            StringBuilder sb = new StringBuilder();
            int number = nums[i];
            while (number >= 1) {
                if (nums[i] % number == 0) {
                    stack.push(number);
                    if (number % 2 == 0) {
                        number = number / 2;
                    }
                    else
                        number--;
                }
                else
                    number--;

            }
            while (!stack.isEmpty())
                sb.append(stack.pop());
            if (sb.toString().contains(k + ""))
                res++;
        }
        System.out.println(res);

    }


}
