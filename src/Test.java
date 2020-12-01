/**
 * @author zxs666
 * @date 2020/11/18 20:52
 */
public class Test {

    class A{
        protected  int get(){
            return 1;
        }
    }
    class B extends  A{
        public int  getB(A aa){
            return aa.get();
        }
    }
}
