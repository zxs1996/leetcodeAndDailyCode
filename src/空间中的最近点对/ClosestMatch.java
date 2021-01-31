package 空间中的最近点对;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/9 22:17
 */
public class ClosestMatch {

    @Test
    public void test() {
        int N = 80000;
        int[][] points = new int[N][2];
        Random random = new Random();
        int maxNum = 100000000;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int x = random.nextInt(maxNum);
            int y = random.nextInt(maxNum);
            //避免重复点
           /* while (map.containsKey(x) && map.get(x) == y) {
                x = random.nextInt(maxNum);
                y = random.nextInt(maxNum);
            }*/
            points[i][0] = x;
            points[i][1] = y;
        }

        long start = System.currentTimeMillis();
        forceFind(points);

        long end = System.currentTimeMillis();
        System.out.println("暴力算法耗费时间:" + (end - start));


        start = System.currentTimeMillis();
        findClosestMatch(points);
        end = System.currentTimeMillis();
        System.out.println("分治算法耗费时间：" + (end - start));
        System.out.println("分治解：" + Arrays.toString(point1) + "," + Arrays.toString(point2) + ",最短距离:" + minDistance);

    }




    int[] point1;
    int[] point2;
    double minDistance = Integer.MAX_VALUE;
    int limit = 25;

    public void findClosestMatch(int[][] points) {
        int[][] X = new int[points.length][2];
        int[][] Y = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            X[i][0] = Y[i][0] = points[i][0];
            X[i][1] = Y[i][1] = points[i][1];
        }

        //X数组按照x坐标递增
        //Y数组按照y坐标递增
        Arrays.sort(X, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(Y, Comparator.comparingInt(o -> o[1]));
        divideAndConquer(X, Y);
    }


    public void divideAndConquer(int[][] X, int[][] Y) {

        int length = X.length;
        //小于3，直接暴力解即可暴力算法
        if (length <= limit) {
            for (int i = 0; i < X.length; i++) {
                for (int j = i + 1; j < X.length; j++) {
                    double tmp = Math.sqrt(Math.pow(X[j][0] - X[i][0], 2) + Math.pow(X[j][1] - X[i][1], 2));
                    if (tmp < minDistance) {
                        point1 = X[i];
                        point2 = X[j];
                        minDistance = tmp;
                    }
                }
            }
        }

        //分治算法
        else {
            //找中位线，
            double middleX;
            //如果长度为偶数，那么选中间两个数的中值
            if (length % 2 == 0) {
                middleX = (X[length / 2][0] + X[length / 2 - 1][0]) / 2;
            }
            //如果是奇数，直接取中位数
            else
                middleX = X[length / 2][0];

            //X划分成划分界成两半XL和XR, Y也分成YL和YR，分线上的一律分到左边去
            //使用leftCount记录分界线及其左边的元素
            int leftCount = 0;
            while (leftCount < X.length && X[leftCount][0] <= middleX)
                leftCount++;
            int[][] XL = Arrays.copyOfRange(X, 0, leftCount);
            int[][] XR = Arrays.copyOfRange(X, leftCount, X.length);
            //System.out.println(XL.length+"--"+XR.length);
            //根据中位线，确定YL YR
            //YL,重合的点，我们放在左边。所以tmpY[0] <= middleX里面有等号
            int[][] YL = new int[XL.length][2];
            int[][] YR = new int[XR.length][2];
            int indexL = 0, indexR = 0;
            for (int[] tmpY : Y) {
                if (tmpY[0] <= middleX)
                    YL[indexL++] = tmpY;
                else
                    YR[indexR++] = tmpY;
            }

            //递归地处理左右两边
            divideAndConquer(XL, YL);
            divideAndConquer(XR, YR);

            //选取在2*minDistance范围内的元素,构造Y'
            List<int[]> listY = new ArrayList<>();
            for (int[] tmp : Y) {
                if (middleX - minDistance <= tmp[0] && tmp[0] <= middleX)
                    listY.add(tmp);
                else if (middleX <= tmp[0] && tmp[0] <= middleX + minDistance)
                    listY.add(tmp);
            }
            int[][] YY = new int[listY.size()][2];
            YY = listY.toArray(YY);
            //计算Y后面的7个数
            for (int i = 0; i < YY.length; i++) {
                for (int j = 1; i + j < YY.length && j <= 7; j++) {
                    double tmp = Math.sqrt(Math.pow(YY[i][0] - YY[i + j][0], 2) + Math.pow(YY[i][1] - YY[i + j][1], 2));
                    if (tmp < minDistance) {
                        point1 = YY[i];
                        point2 = YY[i + j];
                        minDistance = tmp;
                    }
                }
            }
        }
    }


    /**
     * 暴力求解
     *
     * @param points
     * @return
     */
    public double forceFind(int[][] points) {
        double res = Integer.MAX_VALUE;
        int[] point1 = null, point2 = null;
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++) {
                double tmp = Math.sqrt(Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2));
                if (tmp < res) {
                    res = tmp;
                    point1 = points[i];
                    point2 = points[j];
                }
                res = Math.min(res, tmp);
            }
        System.out.println("暴力解：" + Arrays.toString(point1) + "," + Arrays.toString(point2) + ",最短距离：" + res);
        return res;
    }


}
