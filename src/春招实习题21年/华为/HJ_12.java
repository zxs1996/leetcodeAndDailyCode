package 春招实习题21年.华为;


import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/4/1 0:40
 */
public class HJ_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }

        System.out.println(new String(arr));

    }
}
