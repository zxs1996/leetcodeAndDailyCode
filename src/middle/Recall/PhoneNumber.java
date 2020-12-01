package middle.Recall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2019/12/27.
 * 电话号码的组合
 */

public class PhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        List<String> list = new PhoneNumber().letterCombinations(digits);
        for (String id : list
                ) {
            System.out.println(id.toString());
        }
    }








    List<String> list = new ArrayList<>();
    List<char[]> objects = new ArrayList<>();

    {
        objects.add(null);
        objects.add(null);
        objects.add(new char[]{'a', 'b', 'c'});
        objects.add(new char[]{'d', 'e', 'f'});
        objects.add(new char[]{'g', 'h', 'i'});
        objects.add(new char[]{'j', 'k', 'l'});
        objects.add(new char[]{'m', 'n', 'o'});
        objects.add(new char[]{'p', 'q', 'r', 's'});
        objects.add(new char[]{'t', 'u', 'v'});
        objects.add(new char[]{'w', 'x', 'y', 'z'});
    }

    int[] intDigits;
    int length;
    char[] stringChar ;

    public List<String> letterCombinations(String digits) {
        length = digits.length();
        intDigits = new int[length];
        stringChar=new char[length];
        char[] numbers = digits.toCharArray();
        for (int i = 0; i < length; i++)
            intDigits[i] = numbers[i] - '0';
        recall(0);
        return list;
    }

    public void recall(int n) {
        if (n == length) {
            list.add(new String(stringChar));
            return;
        }
        for (int i = 0; i < objects.get(intDigits[n]).length; i++) {
            stringChar[n] = objects.get(intDigits[n])[i];
            recall(n + 1);
        }
    }
}
