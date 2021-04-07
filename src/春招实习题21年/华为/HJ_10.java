package 春招实习题21年.华为;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zxs666
 * @date 2021/4/1 0:40
 */
public class HJ_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray())
            set.add(c);
        System.out.println(set.size());

    }
}
