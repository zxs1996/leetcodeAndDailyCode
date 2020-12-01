import org.junit.Test;

import java.util.*;

public class Num_5513 {



    //prime算法，选点
    public int minCostConnectPoints2(int[][] points) {
        //记录已经包含的点
        Map<Integer, Integer> containPoint = new HashMap<>();
        //记录未包含的点
        Map<Integer, Integer> nonContainPoint = new HashMap<>();
        containPoint.put(0, 1);//初始的时候把起始点放进去
        for (int i = 1; i < points.length; i++)
            nonContainPoint.put(i, 0);
        //distacne[2][5]表示从point2到point5的距离
        int[][] distance = new int[points.length][points.length];//记录两点之间的距离
        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points.length; j++) {
                int row = points[j][0] - points[i][0];
                int col = points[j][1] - points[i][1];
                distance[i][j] = Math.abs(row) + Math.abs(col);
                distance[j][i] = distance[i][j];
            }
        int res = 0;//最短费用
        while (nonContainPoint.size() != 0) {
            System.out.println("已经包含的点：" + containPoint.size());
            for (Integer key : containPoint.keySet())
                System.out.print(key + "  ");

            int minPoint = -1;//此次循环选择的点
            int minDistance = 0;//此次循环选择的最短距离
            Set<Integer> set = containPoint.keySet();
            //从每一个已经包含的点出发，找距离最近的点
            for (Integer key : set) {
                System.out.print("key:" + key + "  " + "contain:");
                for (int i = 0; i < distance[key].length; i++) {
                    //如果这个点没有被用过，
                    if (nonContainPoint.containsKey(i)) {
                        //如果当前没有选择任何点或者minDistance>当前距离，注意这里不能使用minPoint来作为判断依据，
                        // 因为当key不同，所选取的minPoint不同，
                        if (minPoint == -1 || (minDistance > distance[key][i])) {
                            minPoint = i;
                            minDistance = distance[key][i];
                            System.out.println(minDistance);
                        }
                    }
                }
            }
            System.out.println();
            res += minDistance;
            //System.out.println("minPoint:"+minPoint+"mindistance:"+minDistance);
            nonContainPoint.remove(minPoint);
            containPoint.put(minPoint, 1);
        }
        return res;

    }

    @Test
    public void demo() {
        int[][] points = {{2, -3}, {-17, -8}, {13, 8}, {-17, -15}};
        System.out.println(minCostConnectPoints(points));
    }

    class MyEdge {
        int distance;
        int point1;
        int point2;

        public MyEdge(int distance, int point1, int point2) {
            this.distance = distance;
            this.point1 = point1;
            this.point2 = point2;
        }
    }

    //克鲁斯卡尔，选边
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<MyEdge> queue = new PriorityQueue<>(new Comparator<MyEdge>() {
            @Override
            public int compare(MyEdge o1, MyEdge o2) {
                return o1.distance > o2.distance ? 1 : -1;
            }
        });

        //判断是不是一个完整的联通分量
        int[] pre = new int[points.length];
        for (int i = 0; i < pre.length; i++)
            pre[i] = i;//最开始每一个点都是单独的点

        int[][] distance = new int[points.length][points.length];//记录两点之间的距离
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++) {
                if (i == j)
                    continue;
                int row = points[j][0] - points[i][0];
                int col = points[j][1] - points[i][1];
                distance[i][j] = Math.abs(row) + Math.abs(col);
                queue.add(new MyEdge(distance[i][j], i, j));

            }
        int res = 0;
        int count = 0;
        while (count < points.length - 1) {
            MyEdge shortEdge = queue.poll();
            int graph1 = unionSearch(shortEdge.point1, pre);
            int graph2 = unionSearch(shortEdge.point2, pre);
            //如果他们在一个联通分量里面，那么continue
            if (graph1 == graph2)
                continue;
            join(shortEdge.point1, shortEdge.point2, pre);
            res += shortEdge.distance;
            count++;
        }
        return res;

    }


    public void join(int x, int y, int[] pre) {
        //找这两个元素的最高领导
        int xFather = unionSearch(x, pre);
        int yFather = unionSearch(y, pre);
        //如果这两个元素不属于一个集合，那么将他们归为一个集合
        if (xFather != yFather)
            pre[xFather] = yFather;
    }

    //查找元素属于的集合
    public int unionSearch(int x, int[] pre) {

        int root = x, temp;
        //如果不是掌门，那么一直网上找
        while (x != pre[x])
            x = pre[x];

        //路径压缩，把寻找路上遇到的所有的点的上级都直接设置为掌门，方便下次查询
        while (root != x) {
            temp = pre[root];//记录它的上级
            pre[root] = x;//将它的上级直接设为掌门，下次查询更快
            root = temp;//对前面一个上级做相同操作
        }
        return x;
    }
}
