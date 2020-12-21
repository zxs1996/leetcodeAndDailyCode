package 力扣_1_100;


/**
 * Created by zxs666 on 2020/7/13.
 */
public class Num_67 {

    public static void main(String[] args) {
       Num_67 num_67=new Num_67();
       String a="1010110";
       String b="1001001010100101";
       String ans=num_67.addBinary(a,b);
       System.out.println(ans);
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;
        char arr1[] = a.toCharArray();
        char arr2[] = b.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        char ans[] = new char[Math.max(len1, len2)];
        int i = len1 - 1;
        int j = len2 - 1;
        int index = ans.length - 1;
        char carry = '0';
        for (; i >= 0 && j >= 0; i--, j--) {
            if (arr1[i] == '1' && arr2[j] == '1') {
                ans[index--] = carry;
                carry = '1';
            } else if (arr1[i] == '0' && arr2[j] == '0') {
                ans[index--] = carry;
                carry = '0';
            } else {
                //进位为1,那么当前位为0，如果进位为0，那么当前位为1.这里比较细节
                ans[index--] = carry == '1' ? '0' : '1';
            }
        }
        while (i >= 0) {
            if (arr1[i] == '1' && carry == '1') {
                ans[index--] = '0';
                carry = '1';
            } else if (arr1[i] == '0' && carry == '0') {
                ans[index--] = '0';
                carry = '0';
            } else {
                ans[index--] = '1';
                carry = '0';
            }
            i--;
        }
        while (j >= 0) {
            if (arr2[j] == '1' && carry == '1') {
                ans[index--] = '0';
                carry = '1';
            } else if (arr2[j] == '0' && carry == '0') {
                ans[index--] = '0';
                carry = '0';
            } else {
                ans[index--] = '1';
                carry = '0';
            }
            j--;
        }
        if (carry == '1')
            return '1' + String.valueOf(ans);
        else return  String.valueOf(ans);
    }
}
