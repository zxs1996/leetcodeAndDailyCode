package 力扣_301_400;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/10/2 14:23
 */
public class Num_318 {

    @Test
    public void test1() {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        maxProduct(words);
    }


    //方法1，暴力二重循环
    public int maxProduct(String[] words) {
        //先按照字符串长度排序
        Arrays.sort(words, (str1, str2) -> str2.length() - str1.length());
        System.out.println(Arrays.toString(words));
        int res = 0;
        boolean[][] flag = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray())
                flag[i][c - 'a'] = true;
        }
        for (int i = 0; i < words.length; i++) {
            //剪枝
            if (words[i].length() * words[i].length() <= res)
                break;
            for (int j = i; j < words.length; j++) {
                //剪枝
                if (words[i].length() * words[j].length() <= res)
                    break;
                boolean notHavePublicChar = true;
                //判断是不是有公共字符
                for (int k = 0; k < 26; k++)
                    if (flag[i][k] && flag[j][k]) {
                        notHavePublicChar = false;
                        break;
                    }
                if (notHavePublicChar)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }

    //使用位运算，一个int占32位用低26位表示a-d是否出现，如果出现那么为1，不出现那么为0;
    public int maxProduct2(String[] words) {

        int res = 0;
        int arr[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray())
                //左移运算，比如出现了c，那么c-‘a’=2,1左移两位到第三个位置，然后在做与运算
                arr[i] |= 1 << c - 'a';
        }

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {
              
                //如果两个字符串与起来为0，说明没有公共字符
                if ((arr[i] & arr[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());

            }
        }
        return res;
    }


}
