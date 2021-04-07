package 春招实习题21年.华为;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/30 0:24
 */
public class HJ_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();

        char key = sc.nextLine().charAt(0);
        if (key < 'a')
            key+=32;
        int res = 0;
        System.out.println(key);
        for (char c : str.toCharArray()) {
            if (c == key)
                res++;
        }

        System.out.println(res);
    }

    @Test
    public void test() {
        char c = 'a';
        char b = 'A';
        System.out.println((int) (c));
        System.out.println((int) (b));
    }
}
