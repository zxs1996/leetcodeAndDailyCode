import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/13 10:36
 */
public class Num_5919 {

    public int numberOfMatches(int n) {
        int res=0;
        while(n>1){
            res+=n/2;
            n=(int)Math.ceil((double)n/2);
            System.out.println(n);

        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minPartitions("0000"));
    }

    public int minPartitions(String n) {
        char res='0';
        for(char c:n.toCharArray())
            if(c>res)
                res=c;
        return Integer.valueOf(res+"");
    }



}
