package 力扣_1_100;

/**
 * Created by zxs666 on 2020/6/18.
 *
 * //回文数
 */
public class Num_9 {

    public static void main(String[] args) {
        boolean result=new Num_9().isPalindrome(121);
        System.out.println(result);
    }
    public boolean isPalindrome(int x) {

        int orrginalX=x;
        if(x<0)
            return false;
        int y=0;
        while(x/10!=0){
            int temp=x%10;
            y=y*10+temp;
            x=x/10;
        }
        y=y*10+x;
        System.out.println(y);
        return y==orrginalX;

    }
}
