package num_201_300;

import java.util.*;

/**
 * Created by zxs666 on 2020/8/1.
 * 拓扑排序
 */
public class Num_207 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] num = new int[numCourses];
        //记录每门课程的前导课程数量
        for (int i = 0; i < prerequisites.length; i++)
            num[prerequisites[i][0]]++;
        int count = 0;
        //找前导课为0的课程学习
        while (count != numCourses) {
            int countTemp = count;
            //这里的循环次数是课程数量
            for (int i = 0; i < numCourses; i++) {
                //前驱为0
                if (num[i] == 0) {
                    count++;
                    //修改所有以该节点为前驱的节点
                    //这里的循环次数是prerequisites长度
                    for (int j = 0; j < prerequisites.length; j++) {
                        if (prerequisites[j][1] == i)
                            num[prerequisites[j][0]]--;
                    }
                    num[i] = -1;//修改为-1
                    break;
                }
            }
            //如果一轮循环找不到可以学习的课程，那么返回false
            if (count == countTemp)
                return false;
        }
        return true;
    }


}
