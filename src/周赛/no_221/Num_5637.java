/**
 * @author zxs666
 * @date 2020/12/27 11:45
 */
public class Num_5637 {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String str1 = s.substring(0, n / 2);
        String str2 = s.substring(n / 2, n);
        int count1 = 0, count2 = 0;
        for (char c : str1.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                count1++;
        }

        for (char c : str2.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                count2++;
        }
        return count1 == count2;
    }
}
