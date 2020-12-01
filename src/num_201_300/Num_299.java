package num_201_300;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num_299 {
    @Test
    public void demo() {
        System.out.println(Integer.parseInt('0' + ""));
    }

    public String getHint(String secret, String guess) {
        int countA = 0, countB = 0;
        int nums[] = new int[10];
        Arrays.fill(nums, 0);

        //先将每个字符出现的次数放入桶
        for (char c : secret.toCharArray())
            nums[Integer.parseInt(c + "")]++;

        //第一轮统计位置正确的元素
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
                countA++;
                nums[Integer.parseInt(c + "")]--;
            }
        }
        //统计位置不正确的元素
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c != secret.charAt(i) && nums[Integer.parseInt(c + "")] !=0) {
                countB++;
                nums[Integer.parseInt(c + "")]--;
            }
        }
        return countA + "A" + countB + "B";
    }
}
