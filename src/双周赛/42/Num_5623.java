/**
 * @author zxs666
 * @date 2020/12/26 22:54
 */
public class Num_5623 {
    public String maximumBinaryString(String binary) {
        if (binary == null || binary.length() < 2)
            return binary;
        char[] arr = binary.toCharArray();
        int start = 0;
        while (start<binary.length()&&arr[start] == '1')
            start++;
        int end = start + 1;
        while (end < arr.length) {
            if (arr[end] == '0') {
                arr[end] = '1';
                arr[start] = '1';
                arr[start + 1] = '0';
                start++;
            }
            end++;
        }
        return new String(arr);
    }

}
