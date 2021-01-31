package 空间中的最近点对;

import org.junit.Test;

import java.nio.channels.Pipe;
import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/9 22:17
 */
public class ClosestMatch2 {

    @Test
    public void test() {
        int N = 5000;
        Point[] points = new Point[N];
        Random random = new Random();
        int beishu = 1000000;


        for (int i = 0; i < N; i++) {
            double x = random.nextDouble() * beishu;
            double y = random.nextDouble() * beishu;
            points[i] = new Point("number" + i, x, y);

        }

        long start = System.currentTimeMillis();
        forceFind(points);

        long end = System.currentTimeMillis();
        System.out.println("暴力算法耗费时间:" + (end - start));


        start = System.currentTimeMillis();
        findClosestMatch(points);
        end = System.currentTimeMillis();
        System.out.println("分治算法耗费时间：" + (end - start));
        System.out.println("分治解：" + p1 + "," + p2 + ",最短距离:" + minDistance);

    }


    //记录最优解
    Point p1;
    Point p2;
    double minDistance = Integer.MAX_VALUE;
    private int limit = 25;

    /**
     * 传入一个点集数组，计算最近的两个点，以数组的方式返回
     *
     * @param points
     * @return
     */
    public Point[] findClosestMatch(Point[] points) {
        Point[] X = new Point[points.length];
        Point[] Y = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            X[i] = Y[i] = points[i];
        }

        //X数组按照x坐标递增
        Arrays.sort(X, Comparator.comparingDouble(o -> o.x));
        //Y数组按照y坐标递增
        Arrays.sort(Y, Comparator.comparingDouble(o -> o.y));
        divideAndConquer(X, Y);
        return new Point[]{p1, p2};
    }


    /**
     * 递归的划分
     *
     * @param X
     * @param Y
     */
    private void divideAndConquer(Point[] X, Point[] Y) {

        int length = X.length;
        //小于limit，直接暴力解即可
        if (length <= limit) {
            for (int i = 0; i < X.length; i++) {
                for (int j = i + 1; j < X.length; j++) {
                    double tmp = Math.sqrt(Math.pow(X[j].x - X[i].x, 2) + Math.pow(X[j].y - X[i].y, 2));
                    if (tmp < minDistance) {
                        p1 = X[i];
                        p2 = X[j];
                        minDistance = tmp;
                    }
                }
            }
        }

        //分治算法
        else {
            //找x中位线，分成两半
            double middleX;
            //如果长度为偶数，那么选中间两个数的中值
            if (length % 2 == 0) {
                middleX = (X[length / 2].x + X[length / 2 - 1].x) / 2;
            }
            //如果是奇数，直接取中位数
            else
                middleX = X[length / 2].x;

            //利用中位线将X划分成划分界成两半XL和XR, Y也分成YL和YR，分线上的一律分到左边去
            //使用leftCount记录分界线及其左边的元素
            int leftCount = 0;
            while (leftCount < X.length && X[leftCount].x <= middleX)
                leftCount++;
            Point[] XL = Arrays.copyOfRange(X, 0, leftCount);
            Point[] XR = Arrays.copyOfRange(X, leftCount, X.length);
            //System.out.println(XL.length+"--"+XR.length);
            //根据中位线，确定YL YR
            //YL,重合的点，我们放在左边。所以tmpY[0] <= middleX里面有等号
            Point[] YL = new Point[XL.length];
            Point[] YR = new Point[XR.length];
            int indexL = 0, indexR = 0;
            for (Point tmpY : Y) {
                if (tmpY.x <= middleX)
                    YL[indexL++] = tmpY;
                else
                    YR[indexR++] = tmpY;
            }

            //递归地处理左右两边
            divideAndConquer(XL, YL);
            divideAndConquer(XR, YR);

            //左右两边处理完了之后，进入核心环节
            //选取在2*minDistance范围内的元素,构造Y'
            //Y是有序的，构造出来的Y‘也是有序的
            List<Point> listY = new ArrayList<>();
            for (Point tmp : Y) {
                if (middleX - minDistance <= tmp.x && tmp.x <= middleX)
                    listY.add(tmp);
                else if (middleX <= tmp.x && tmp.x <= middleX + minDistance)
                    listY.add(tmp);
            }

            //转成数组，下标索引方便一些，比较好计算
            Point[] YY = new Point[listY.size()];
            YY = listY.toArray(YY);
            //计算每个点后面最多7个点
            for (int i = 0; i < YY.length; i++) {
                for (int j = 1; i + j < YY.length && j <= 7; j++) {
                    double tmp = calculate(YY[i], YY[i + j]);
                    if (tmp < minDistance) {
                        p1 = YY[i];
                        p2 = YY[i + j];
                        minDistance = tmp;
                    }
                }
            }
        }
    }


    /**
     * 计算两点之间的距离
     *
     * @param p1
     * @param p2
     * @return
     */
    public double calculate(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }


    /**
     * 暴力求解
     *
     * @param points
     * @return
     */
    private double forceFind(Point[] points) {
        double res = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++) {
                double tmp = calculate(points[i], points[j]);
                if (tmp < res) {
                    res = tmp;
                    p1 = points[i];
                    p2 = points[j];
                }
                res = Math.min(res, tmp);
            }
        System.out.println("暴力解：" + p1 + "," + p2 + ",最短距离：" + res);
        return res;
    }


}
