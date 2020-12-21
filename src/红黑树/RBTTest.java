package 红黑树;

import java.io.*;

/**
 * @author zxs666
 * @date 2020/11/17 17:11
 */
public class RBTTest {


    public static void main(String[] args) throws IOException{

        //1、读取数据
        int[] nums = getArrayByReadFile("C:\\Users\\admin\\Desktop\\算法实验\\实验二红黑树插入\\insert.txt");

        //2、给定数据创建红黑树
        RedBlackTree rbt = new RedBlackTree();
        for (int num : nums)
            rbt.RBInsert(num);

        //3、打印红黑树
        rbt.RBShow();
        //3、将红黑树的先序和中序存入文件
        WriteFile(rbt.getNLRString(), "C:\\Users\\admin\\Desktop\\算法实验\\实验二红黑树插入\\NLR.txt");
        WriteFile(rbt.getLNRString(), "C:\\Users\\admin\\Desktop\\算法实验\\实验二红黑树插入\\LNR.txt");
    }



    //从文件读数据放入数组
    public static  int[] getArrayByReadFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));//构造一个BufferedReader类来读取文件


        int number = Integer.valueOf(br.readLine());
        int[] nums = new int[number];

        String[] strs = br.readLine().split(" ");

        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.valueOf(strs[i]);
        return nums;
    }


    //将红黑树的先序和中序序列写入文件
    public static void WriteFile(String str, String filePath) throws IOException {
        File file = new File(filePath);
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));//构造一个BufferedReader类来读取文件
        bf.write(str);
        bf.flush();
    }


}
