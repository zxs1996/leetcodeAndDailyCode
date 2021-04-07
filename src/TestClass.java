import java.util.HashSet;

/**
 * @author zxs666
 * @date 2021/4/2 21:11
 */
public class TestClass {
    public static void main(String[] args) {
        try {
            Class.forName("ZXS");
         
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
