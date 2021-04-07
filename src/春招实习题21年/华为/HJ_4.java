package 春招实习题21年.华为;

import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/30 0:31
 */
public class HJ_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.length() % 8 != 0) {
                int need = str.length() % 8;
                for (int i = 0; i < 8 - need; i++)
                    str += "0";
            }

            while (str.length() >= 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8, str.length());
            }
        }


    }
}
