import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/6 10:32
 */
public class Num_5617 {


    @Test
    public void test1(){
        String commond="G()(al)()";
        String str=commond.replace("()","o");
        String res=str.replace("(al)","al");
        System.out.println(res);
    }
    public String interpret(String command) {
        String str1=command.replaceAll("G","G");
        String str2=str1.replaceAll("()","o");
        String str3=str2.replaceAll("(al)","al");
        return str3;
    }
}
