package 春招实习题21年.百度;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2021/3/30 19:26
 */
public class 牛牛的硬币 {

    /**
     * 5 01212
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int p = scanner.nextInt();
        int[] nums = new int[N * 2];
        for (int i = 0; i < N * 2; i++)
            nums[i] = scanner.nextInt();

        //对数据排序从小到大
        Arrays.sort(nums);


        //用来装分组，每个分组两个数，根据P的值来决定
        int[][] arr = new int[N][2];

        //如果大于50，那么按照一大一下分在一组
        if (p > 50) {
            int i = 0, j = N * 2 - 1;
            for (int k = 0; k < N; k++) {
                arr[k][0] = nums[i++];
                arr[k][1] = nums[j--];
            }
        }
        //否则，大的跟大的一组，小的跟小的一组
        else {
            int i = 0;
            for (int k = 0; k < N; k++) {
                arr[k][0] = nums[i++];
                arr[k][1] = nums[i++];
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res += p * arr[i][1] + (100 - p) * arr[i][0];
        }
        if(res%100==0)
            System.out.println(res/100);
        else
            System.out.println(res+"%");
    }
}
