package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/28.
 */
public class Num_151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        StringBuffer sb = new StringBuffer("");
        int end = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            //如果不是空格字符并且end<0,说明找到一个单词的结束
            if (s.charAt(i) != ' ' && end < 0)
                end = i + 1;
                //如果是空格并且end>0，说明找到一个单词的开始
            else if (s.charAt(i) == ' ' && end > 0) {
                sb.append(s.substring(i + 1, end) + " ");
                end = -1;
            }
        }
        if (end > 0)
            sb.append(s.substring(0, end));
        if(sb.length()>0&&sb.charAt(sb.length()-1)==' ')
            return  sb.substring(0,sb.length()-1);
        return sb.toString();
    }
}
