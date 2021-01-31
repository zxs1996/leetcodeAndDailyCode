package 回溯算法.最佳调度问题;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2020/12/22 17:16
 */
public class BestDisPatchTest {
    public static void main(String[] args) {
        BestDispatch bd = new BestDispatch();
        int n = 7;
        int k = 3;
        double[] cost = {2, 14, 4, 16, 6, 5, 3};

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入任务数n,机器数k，以空格分隔: ");
        n = sc.nextInt();
        k = sc.nextInt();
        cost = new double[n];
        System.out.println("请输入" + n + "个任务的时间，每个任务以空格分开");
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextDouble();
        }


        Object[] objects = bd.bestDispatch(n, k, cost);


        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("最佳调度时间为: " + df.format(objects[0]));
        System.out.println("最佳调度方案如下");
        Deque<Integer>[] deques = (Deque[]) objects[1];
        for (int i = 0; i < deques.length; i++) {
            System.out.print(("machine" + i) + ":");
            for (int jobIndex : deques[i]) {
                System.out.print("<" + (jobIndex + 1) + "," + cost[jobIndex] + "> ");
            }
            System.out.println();
        }
    }
}
