package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/30.
 */
public class Num_172 {
    public static void main(String[] args) {
        int res = new Num_172().trailingZeroes(15);
        System.out.println(res);
    }

    //每隔5个数出现一个5，每隔25个数出现2个五（其中有一个5在隔5的时候出现了)，每隔125个数出现3个5
   //res=n/5+n/25+n/125+.....
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

}
