package 最大公约数;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/29 10:47
 */
public class GCD {

    public int gcd(int a,int b){
        if(a<b)
            gcd(b,a);
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

    @Test
    public void test1(){
        System.out.println(gcd(35,14));
    }
}
