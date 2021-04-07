package 春招实习题21年.华为;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zxs666
 * @date 2021/4/1 0:40
 */
public class HJ_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();


        String str = "";
        while (number > 0) {
            str += number % 10;
            number /= 10;
        }
        System.out.println(str);

    }
}
