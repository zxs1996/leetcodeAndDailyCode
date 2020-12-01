package num_201_300;

/**
 * Created by zxs666 on 2020/8/1.
 */
public class Num_201 {
    //找二进制字符串的公共前缀，因为一旦有一个不匹配，那么就是为0
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while (m != n) {
            m >>= 1;//右移
            n >>= 1;//右移
            res++;
        }
        return m <<= res;
    }
}
