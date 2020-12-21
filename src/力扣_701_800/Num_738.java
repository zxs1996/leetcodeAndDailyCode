package 力扣_701_800;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/15 16:13
 */
public class Num_738 {

    @Test
    public void test() {
        System.out.println(monotoneIncreasingDigits(120));
    }

    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        int n = str.length();
        char[] arr = str.toCharArray();

        //从后往前找，每找到一个不合规字符，让它-1，后面的全部设置为9
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                arr[i - 1]--;
                for (int j = i; j < n && arr[j] != '9'; j++)
                    arr[j] = '9';
            }
        }
     
        return Integer.valueOf(String.valueOf(arr));
    }
}
