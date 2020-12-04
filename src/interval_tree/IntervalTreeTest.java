package interval_tree;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @author zxs666
 * @date 2020/11/17 17:11
 * 区间树的测试
 */
public class IntervalTreeTest {




    public static void main(String[] args) throws IOException {


         //1、从文件获取数据存入数组
        int[][] nums=getArrayByReadFile("C:\\Users\\admin\\Desktop\\算法实验\\实验三区间树\\insert.txt");
                //{{50,60},{20 ,25},{70 ,90},{15 ,22},{30 ,32},{25, 28},{35,40},{32 ,34}};



        //2、数据插入区间树
        IntervalTree intervalTree=new IntervalTree();
        for(int[] num:nums){
            Interval interval=new Interval(num[0],num[1]);
            intervalTree.RBInsert(interval);
        }
        //intervalTree.RBShow();


        //3、执行查询
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.print("请输入要查找区间，以空格隔开：");
            int low=sc.nextInt();
            int high=sc.nextInt();
            while(low>high)
            {
                System.out.print("左边界要小于右边界，请重新输入：");
                low=sc.nextInt();
                high=sc.nextInt();
            }
            Interval searchResult=intervalTree.RBSearch(new Interval(low,high));
            if(searchResult==null)
                System.out.println("你输入的区间找不到\n");
            else{
                System.out.println("查找到的重叠区间为：["+searchResult.low+","+searchResult.high+"]\n");
            }
        }
    }



    //从文件读数据放入数组
    public static  int[][] getArrayByReadFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));//构造一个BufferedReader类来读取文件


        int number = Integer.valueOf(br.readLine());
        int[][] nums = new int[number][2];



        for (int i = 0; i < nums.length; i++){
            String line=br.readLine();
            String[] strs=line.split(" ");

            nums[i][0] =Integer.valueOf(strs[0]);
            nums[i][1] =Integer.valueOf(strs[1]);

        }

        return nums;
    }





}
