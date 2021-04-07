package 春招实习题21年.京东;

import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/27 18:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        while (sc.hasNextInt()) {
            double n = sc.nextInt();
            int m = sc.nextInt();
            double sum = 0;
            for (int i = 0; i < m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            System.out.println(df.format(sum));
        }
    }





}
