package num_1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/6/18.
 * 第6题 Z字型
 */
public class Num_6 {

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String result = new Num_6().convert2(str, 3);
        System.out.println(result);
    }


    //开辟二维数组，将给定字符串按照格式放入二维数组，对应位置没有字符就填空格 最后遍历二维数组
    //缺点：时间复杂度空间复杂度高
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int length = s.length();
        char chars[][] = new char[numRows][length];
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < length; j++)
                chars[i][j] = ' ';
        int nowColumn = 0, nowRow = 0;
        for (int k = 0; k < length; ) {
            //竖着一列
            while (nowRow != numRows && k < length)
                chars[nowRow++][nowColumn] = s.charAt(k++);


            nowRow -= 2;
            nowColumn++;
            //斜着
            for (; nowRow > 0 && k < length; nowRow--, nowColumn++, k++)
                chars[nowRow][nowColumn] = s.charAt(k);
        }
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < length; j++)
                if (chars[i][j] != ' ')
                    sb.append(chars[i][j]);
        return sb.toString();
    }


    //找出排列规律，开辟numRows这么多个StringBuffer，将每一个字符放入对应的Buffer，最后拼接几个buffer
    public String convert2(String s, int numRows) {
        if (numRows == 1)
            return s;
        //初始化
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuffer());
        int flag = -1;
        int numRow = 0;
        char charArray[] = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            rows.get(numRow).append(charArray[i]);
            //到第一行或者到最后一行，直接翻转
            if (numRow == 0 || numRow == numRows - 1)
                flag = -flag;
            numRow += flag;
        }
        StringBuffer sb = new StringBuffer("");
        for (StringBuffer rowS : rows)
            sb.append(rowS);
        return sb.toString();
    }
}


