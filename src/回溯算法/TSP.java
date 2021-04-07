package 回溯算法;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TSP旅行商问题
 */
public class TSP {


    @Test
    public void test() {
        int nums[][] = {{0, 3, 6, 7}, {5, 0, 2, 3}, {6, 4, 0, 2}, {3, 7, 5, 0}};
        int res = tsp(nums);
        System.out.println(res);
        System.out.println("计算次数：" + countTimes);
    }
    //旅行商问题，现在有一个人要去旅行，他可以从任意一个城市出发，然后游览完所有的城市，然后返回出发城市
    //两个城市之间的费用由数组给出，求出该旅行商的最小费用
    //思路：因为最后必然会形成一个环，所以最优路径无论从哪个点出发都是一样的，所以这里从0号点出发，最后一个顶点返回0号点

    int[][] distance;
    boolean[] visited;
    int minDistance = Integer.MAX_VALUE;
    int citys;
    int countTimes = 0;

    public int tsp(int[][] nums) {
        citys = nums.length;//城市的数量
        visited = new boolean[citys];//访问标志函数
        distance = nums;
        //从0号点出发，分别到1~n-1号点
        for (int i = 1; i < nums.length; i++) {
            visited[i] = true;
            minDistance = Math.min(minDistance, nums[0][i] + recurse(i, 1));
            visited[i] = false;
            System.out.println(i + "--" + minDistance);
        }

        return minDistance;
    }

    public int recurse(int number, int count) {
        countTimes++;
        //如果已经访问过了citys-1这么多个顶点，说明这个点已经是最后的点了，它将返回0号点
        if (count == citys - 1)
            return distance[number][0];

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < citys; i++) {
            //如果当前点被访问过或者当前点是number号点
            if (!visited[i] && i != number)
            {
                visited[i] = true;
                //剪枝，如果当前number到i的距离已经大于等于minDistance了，那么直接continue，没必要往下走了
                if(distance[number][i]>=minDistance)
                    continue;
                res = Math.min(res, distance[number][i] + recurse(i, count + 1));
                visited[i] = false;
            }
        }
        return res;

    }
}
