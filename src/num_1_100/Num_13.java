package num_1_100;

/**
 * Created by zxs666 on 2020/6/18.
 * 罗马数字转整数
 */
public class Num_13 {

    public static void main(String[] args) {
        String str="MCMXCIV";
        System.out.println(new Num_13().romanToInt(str));
    }

    public int romanToInt(String s) {
        int num = 0;
        char chars[] = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            //System.out.println(i+": "+num);
            //1000
            if (chars[i] == 'M')
                num += 1000;
            else if (chars[i] == 'C') {
                //CM  +900
                if (i < (length - 1) && chars[i + 1] == 'M') {
                    num += 900;
                    i++;
                }
                //CD  +400
                else if (i < (length - 1) && chars[i + 1] == 'D') {
                    num += 400;
                    i++;
                } else
                    num += 100;

            } else if (chars[i] == 'X') {
                //XC +90
                if (i < (length - 1) && chars[i + 1] == 'C') {
                    num += 90;
                    i++;
                }
                //XL +40
                else if (i < (length - 1) && chars[i + 1] == 'L') {
                    num += 40;
                    i++;
                } else
                    num += 10;
            }
            else if(chars[i]=='I'){
                //IX +9
                if(i<(length-1)&&chars[i+1]=='X'){
                    i++;
                    num+=9;
                }
                //IV +4
                else if(i<(length-1)&&chars[i+1]=='V'){
                    i++;
                    num+=4;
                }
                else
                    num+=1;

            }
            else if(chars[i]=='V')
                num+=5;
            else if(chars[i]=='L')
                num+=50;
            else if(chars[i]=='D')
                num+=500;
        }
        return num;
    }
}
