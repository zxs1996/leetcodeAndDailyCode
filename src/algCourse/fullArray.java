package algCourse;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @author zxs666
 * @date 2020/10/28 19:35
 * 编写一个算法，就地生成字符数组S[1..n]的所有排列，
 * 要求算法终止时S[1..n]保持初始状态。就地生成表示不使用S以外的数组。
 * 思路：对于S[1..n]可以划分为n个字问题：
 * 子问题1：S[1]放在第一个位置，S[2]到S[n]构成全排列添加到S[1]后面
 * 子问题2：S[2]放在第一个位置，S[1]  S[3]到S[n]构成全排列添加到S[2]后面
 * ......
 * 子问题n：S[n]放在第一个位置，S[1]到S[n-2]构成全排列添加到S[n]后面
 */
public class fullArray {

    int count=0;
    @Test
    public void test() {
        String str = "abcdf";
        createFUllArray(str.toCharArray(), 0);
        String str2 = "def";
        createFUllArray2(str2.toCharArray(),0,new char[str.length()],new boolean[str.length()]);
        System.out.println(count);
    }


    //不适用额外数组
    public void createFUllArray(char[] chars, int n) {
        count++;
        if (n == chars.length)
            System.out.println(chars);
        for (int i = n; i < chars.length; i++) {
            swap(chars, i, n);
            createFUllArray(chars, n + 1);
            swap(chars, i, n);
        }
    }

    //使用额外数组
    public void createFUllArray2(char[] chars, int n, char[] ans, boolean[] visited) {
        if (n == chars.length)
            System.out.println(ans);
        for (int i = 0; i < chars.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            ans[n]=chars[i];
            createFUllArray2(chars, n + 1, ans, visited);
            visited[i] = false;
        }
    }

    public void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
