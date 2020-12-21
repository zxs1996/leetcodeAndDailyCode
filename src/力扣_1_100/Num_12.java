package 力扣_1_100;

/**
 * Created by zxs666 on 2020/6/18.
 * 整数转罗马数字
 */
public class Num_12 {

    public static void main(String[] args) {


        System.out.println(new Num_12().intToRoman(1994));
    }

    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer("");
        //1、先处理个位
        int gewei = num % 10;
        int shiwei = num / 10 % 10;
        int baiwei = num / 100 % 10;
        int qianwei = num / 1000 % 10;
        //千位
        if (qianwei != 0) {
            for (int i = 0; i < qianwei; i++)
                sb.append('M');
        }
        //百位
        if (baiwei != 0) {
            if (baiwei >= 5) {
                if (baiwei == 9)
                    sb.append("CM");
                else {
                    sb.append("D");
                    for (int i = 5; i < baiwei; i++)
                        sb.append('C');
                }
            } else {
                if (baiwei == 4)
                    sb.append("CD");
                else {
                    for (int i = 0; i < baiwei; i++)
                        sb.append('C');
                }
            }
        }

        //十位
        if (shiwei != 0) {
            if (shiwei >= 5) {
                if (shiwei == 9)
                    sb.append("XC");
                else {
                    sb.append("L");
                    for (int i = 5; i < shiwei; i++)
                        sb.append('X');
                }
            } else {
                if (shiwei == 4)
                    sb.append("XL");
                else {
                    for (int i = 0; i < shiwei; i++)
                        sb.append('X');
                }
            }
        }
        //个位
        if (gewei != 0) {
            if (gewei >= 5) {
                if (gewei == 9)
                    sb.append("IX");
                else {
                    sb.append("V");
                    for (int i = 5; i < gewei; i++)
                        sb.append('I');
                }
            } else {
                if (gewei == 4)
                    sb.append("IV");
                else {
                    for (int i = 0; i < gewei; i++)
                        sb.append('I');
                }
            }
        }
        return sb.toString();
    }
}
