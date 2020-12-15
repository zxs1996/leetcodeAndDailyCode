import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/6 13:27
 *
 * 快速幂等
 */
public class MOD {

    int MOD = 1000000007;

    @Test
    public void test(){
        long res=QuickPower(2,64);
        System.out.println(Math.pow(2,32)%MOD);
        System.out.println(res);
    }

    //（a*b)%p=(a%p)*（b%p)%b,快速幂
    long QuickPower(long a, long b) {
        int MOD = 1000000007;
        long ans = 1;
        while (b > 0) {
            //如果当前是奇数，次数是奇数，那么乘上1个。
            //这里使用位运算，效率更高
            if ((b & 1) > 0) {
                ans = (ans * a) % MOD;
            }
            //指数减少一倍
            b >>= 1;
            //底数增加一倍,摸上MOD，结果不变
            a = (a * a) % MOD;
        }
        return ans;
    }

}
