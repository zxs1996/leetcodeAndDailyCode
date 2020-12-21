package 力扣_more_1000;

/**
 * @author zxs666
 * @date 2020/11/25 12:07
 */
public class Num_1370 {
    public String sortString(String s) {
        StringBuilder sb=new StringBuilder("");
        int[] number=new int[26];

        char[] arr=s.toCharArray();
        for(char c:arr)
            number[c-'a']++;
        int count=0;
        while(count<s.length()){
            for(int i=0;i<26;i++){
                if(number[i]!=0){
                    sb.append((char)(i+'a'));
                    number[i]--;
                    count++;
                }

            }
            for(int i=25;i>=0;i--)
                if(number[i]!=0)
                {
                    sb.append((char)(i+'a'));
                    number[i]--;
                    count++;
                }
        }
        return sb.toString();
    }
}
