package 春招实习题21年.京东;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/27 18:44
 */
public class 水仙花数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer> list=new ArrayList<>();
            for(int i=n;i<=m;i++){
                if(check(i))
                    list.add(i);
            }

            if(list.size()==0)
                System.out.println("no");
            else
               for(int num:list)
                   System.out.print(num+" ");

        }
    }

    public static boolean check(int number) {
        int temp = number;
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            list.add(number % 10);
            number /= 10;
        }

        int sum = 0;
        for (int num : list) {
            sum += num * num * num;
        }

        return sum ==temp;
    }
}
