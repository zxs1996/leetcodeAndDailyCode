import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/6 10:41
 */
public class Num_5620 {


    @Test
    public void test() {
        long start = System.currentTimeMillis();
        System.out.println(concatenatedBinary3(42));
        long end = System.currentTimeMillis();
        System.out.println("总共时间:" + (end - start));
    }

    public int concatenatedBinary(int n) {
        int MOD = 1000000007;
        long res = 0;
        StringBuffer sb = new StringBuffer("");
        long start = System.currentTimeMillis();
        for (int i = 1; i <= n; i++)
            sb.append(Integer.toBinaryString(i));

        long end = System.currentTimeMillis();
        System.out.println("toStringTime:" + (end - start));
        String resStr = sb.toString();
        System.out.println("resStr的长度：" + resStr.length());
        long preMod = 0;
        for (int j = n; j >= 1; j--) {
            String str = Integer.toBinaryString(j);
            for (int i = str.length() - 1; i >= 0; i--) {
                if (preMod == 0)
                    preMod = 1;
                else
                    preMod = (2 % MOD * preMod) % MOD;
                if (resStr.charAt(i) == '0')
                    continue;

                res = (res + preMod) % MOD;
            }
        }


        start = System.currentTimeMillis();
        System.out.println("power:" + (start - end));
        return (int) (res % MOD);

    }


    public int concatenatedBinary2(int n) {
        int MOD = 1000000007;
        long res = 0;
        long preMod = 0;
        for (int j = n; j >= 1; j--) {
            String str = Integer.toBinaryString(j);
            for (int i = str.length() - 1; i >= 0; i--) {
                if (preMod == 0)
                    preMod = 1;
                else
                    preMod = (2 % MOD * preMod) % MOD;
                if (str.charAt(i) == '0')
                    continue;
                res = (res + preMod) % MOD;
            }
        }

        return (int) (res % MOD);

    }


    public int concatenatedBinary3(int n) {
        int MOD = 1000000007;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            int moveTime = (int) (Math.floor(Math.log(i) / Math.log(2)))+1;
            //System.out.println(moveTime);
            res=(res*(long) (Math.pow(2, moveTime) % MOD))%MOD;
            res =(res+i)%MOD;
        }
        return (int) (res % MOD);
    }

    public int get(int n) {
        int a = 2, b = 1, m = 1000000007;
        while (n > 0) {
            if ((n & 1) == 1)
                b = (a * b) % m;
            a = (a * a) % m;
            n >>= 1;
        }
        return b;
    }




    long solve(int n) {
        int MOD = 1000000007;
        return 1;
    }


}
