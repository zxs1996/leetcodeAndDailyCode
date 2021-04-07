package 剑指offer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author zxs666
 * @date 2021/3/12 14:16
 */
public class Num_20 {

    @Test
    public void test(){
        String s="1 ";
        System.out.println(isNumber(s));
        Queue<TreeNode> queue=new ArrayDeque();

    }

    public String recreat(String s){
        StringBuffer sb=new StringBuffer("");
        for(char c:s.toCharArray()){
            if(c!=' ')
                sb.append(c);
        }
        return sb.toString();
    }


    public boolean isNumber(String s) {
        s=recreat(s);
        if (s.length() == 0)
            return false;

        boolean flag2 = false;

        char c = s.charAt(0);

        if (c=='+'||c=='-'||(c >= '0' && c <= '9')){
            for (int i = 1; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == '.') {
                    if (flag2)
                        return false;
                    flag2 = true;
                } else if (c == 'e' || c == 'E') {
                    return checkE(s.substring(i+1,s.length()));
                } else if (c < '0' || c > '9')
                    return false;
            }
            if (c >= '0' && c <= '9')
                return true;
            else
                return false;
        }
        else
            return false;

    }

    public boolean checkE(String s) {
        if(s.contains("."))
            return false;
        if(s.length()==0)
            return false;
        char c=s.charAt(0);
        if(c=='+'||c=='-'||(c>='0'&&c<='9')){
            for(int i=1;i<s.length();i++){
                 c=s.charAt(i);

                if(c<'0'||c>'9')
                    return false;
                return true;
            }
            return c>='0'&&c<='9'?true:false;
        }
        else
            return false;


    }
}
