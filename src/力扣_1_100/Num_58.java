package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/9.
 */
public class Num_58 {
    public int lengthOfLastWord(String s) {
        char arr[] = s.toCharArray();
        boolean flag = false;
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ' && flag)
                return count;
            else if (arr[i] != ' ' && !flag) {
                flag = true;
                count++;
            } else if (arr[i] != ' ' && flag)
                count++;
        }
        return count;
    }
}
