package 春招实习题21年.美团;

import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/4/4 10:14
 */
public class 不高兴和 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder("1");

            for (int j = 2; j <= nums[i]; j++)
                if (nums[i] % j == 0)
                    sb.append(j);
                if(sb.toString().contains(k+""))
                    res++;
        }
        System.out.println(res);

    }


}
