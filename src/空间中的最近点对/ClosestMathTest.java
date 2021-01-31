package 空间中的最近点对;

import org.junit.Test;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zxs666
 * @date 2021/1/5 15:29
 */
public class ClosestMathTest {
    public static void main(String[] args) throws IOException {

        //1、从文件读取数据
        String filePath = "C:\\Users\\admin\\Desktop\\算法实验\\实验七空间中最近点对\\实验七：求平面上n个顶点的最近点对问题\\data.txt";
        Point[] points = getDataFromFile(filePath);


        //创建类对象实例来计算最近点对
        ClosestMatch2 cm = new ClosestMatch2();
        Point[] res = cm.findClosestMatch(points);

        DecimalFormat df = new DecimalFormat("0.00");
        for(int i=0;i<points.length;i++)
            for(int j=i+1;j<points.length;j++){
                System.out.println(points[i].id+"-"+points[j].id+": "+df.format(cm.calculate(points[i],points[j])));
            }
        //3、输出最优值
        System.out.println(res[0]);
        System.out.println(res[1]);

        System.out.println("最短距离:" + df.format(cm.calculate(res[0], res[1])));

    }

    public static Point[] getDataFromFile(String filePath) throws IOException {
        List<Point> list = new ArrayList<>();
        BufferedReader bis = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bis.readLine()) != null) {
            String[] number = line.substring(2, line.length() - 1).split(",");
            list.add(new Point(line.charAt(0) + "", Double.parseDouble(number[0]), Double.parseDouble(number[1])));
        }
        Point[] res = new Point[list.size()];
        return list.toArray(res);
    }



}
