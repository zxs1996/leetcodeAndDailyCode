package 空间中的最近点对;

/**
 * @author zxs666
 * @date 2021/1/5 15:32
 */
public class Point {
    String id;
    double x;
    double y;

    public Point(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
