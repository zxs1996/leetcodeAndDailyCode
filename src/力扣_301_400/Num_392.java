package 力扣_301_400;

public class Num_392 {

    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (index == s.length())
                break;
            if (t.charAt(i) == s.charAt(index))
                index++;
        }
        return index == s.length() ? true : false;
    }
}