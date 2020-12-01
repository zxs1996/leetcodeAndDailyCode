package middle.Recall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2019/12/27.
 * 生成括号
 */
public class CreateBracket {

    public static void main(String[] args) {
        List<String> list=new CreateBracket().generateParenthesis(3);
        for (String str:list
             ) {
            System.out.println(str);
        }
    }

    List<String> list = new ArrayList<>();
    int leftNumber, rightNumber, max;
    int haveLeftNumber = 0;
    char[] chars;

    public List<String> generateParenthesis(int n) {
         leftNumber = rightNumber = n;
         max=n*2;
        chars = new char[n*2];
        backTrace(0);
        return list;
    }

    public void backTrace(int n) {
        if (n == max) {
            list.add(new String(chars));
            return;
        }
        //无左括号，只能输入左括号
        if (haveLeftNumber == 0) {
            haveLeftNumber++;
            leftNumber--;
            chars[n]='(';
            backTrace(n + 1);
            haveLeftNumber--;
            leftNumber++;
        }
        //左括号已经消耗完，只能右括号
       else if(leftNumber==0){
            rightNumber--;
            chars[n]=')';
            backTrace(n+1);
            rightNumber++;
        }
        else
        {
            //左括号
            haveLeftNumber++;
            leftNumber--;
            chars[n]='(';
            backTrace(n + 1);
            haveLeftNumber--;
            leftNumber++;

            //右括号
            haveLeftNumber--;
            rightNumber--;
            chars[n]=')';
            backTrace(n + 1);
            haveLeftNumber++;
            rightNumber++;
        }
    }

}

