package 春招实习题21年.美团;

import java.util.*;

/**
 * @author zxs666
 * @date 2021/4/4 10:14
 */
public class 跳方格 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] nums = new int[n][n];
        //判断标志，用于提前判定
        int flag[] = new int[k+1];

        //记录每个元素出现的位置
        Map<Integer, List<int[]>> map = new HashMap<>();

        //记录每个位置的最小和
        int[][] spend = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();

                if (nums[i][j] <= k) {
                    flag[nums[i][j]] = 1;
                    List list = map.getOrDefault(nums[i][j], new ArrayList<>());
                    list.add(new int[]{i, j});
                    map.put(nums[i][j], list);
                }
            }
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] == 0) {
                System.out.println(-1);
                return;
            }
        }


        for (int i = 0; i < n; i++)
            Arrays.fill(spend[i], 0);

        //从2开始，计算从i-1到i的花费
        for (int i = 2; i <= k; i++) {
            List<int[]> list = map.get(i);
            List<int[]> preList = map.get(i - 1);
            for (int[] curArr : list) {
                int minDistance = Integer.MAX_VALUE;
                for (int[] preArr : preList) {

                    minDistance = Math.min(minDistance, spend[preArr[0]][preArr[1]] + calDistance(curArr, preArr));
                }
                spend[curArr[0]][curArr[1]] = minDistance;
            }
        }

        List<int[]> list = map.get(k);
        int res = Integer.MAX_VALUE;
        for (int[] arr : list) {
            res = Math.min(res, spend[arr[0]][arr[1]]);
        }
        System.out.println(res);
    }

    public static int calDistance(int[] arr1, int[] arr2) {
        return Math.abs(arr1[1] - arr2[1]) + Math.abs(arr1[0] - arr2[0]);
    }
}
    /*
    4 4
	1 2 2 1
	2 4 4 1
	4 4 4 2
	1 3 1 2
     */


