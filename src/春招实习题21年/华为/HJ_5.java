package 春招实习题21年.华为;


import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/30 0:31
 */
public class HJ_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[]{10, 11, 12, 13, 14, 15};

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            str = str.substring(2, str.length()).toLowerCase();
            int res = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                int key;
                if (c >= 'a' && c <= 'f')
                    key = arr[str.charAt(i) - 'a'];
                else
                    key = c - '0';
                res +=key*Math.pow(16, str.length() - i-1);
            }

            System.out.println(res);
        }


    }
}
