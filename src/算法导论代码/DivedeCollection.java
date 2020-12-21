package 算法导论代码;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/10/28 20:11
 * 设有n个元素的集合s={a1,a2....an},要求将s划分为k个子集s1,s2...sk
 * 且满足：1、Si不为空，2、任意两个集合元素不重复  3、所有集合合起来是s
 * 设n个元素 a1,a2,…,an放入k个集合的划分数为s(n,k)，考虑一下两种情况：
 * 1、an单独成一个集合，a1....an-1构成k-1个集合
 * 2、an不单独构成集合，它和其它划分构成一个集合,其它划分有S(n-1,K)种，an可以放到任意一个集合里面去，k*S(n-1,k)
 */
public class DivedeCollection {


    @Test
    public void test() {
        System.out.println(divide(4,3));
    }

    public int divide(int n, int k) {
        //不满足条件
        if (n == 0 || n < k)
            return 0;
        //只有一个划分或者划分数刚好等于集合个数，每个元素单独一个集合
        if (k == 1 || n == k)
            return 1;
        return divide(n - 1, k - 1) + k * divide(n - 1, k);

    }
}
