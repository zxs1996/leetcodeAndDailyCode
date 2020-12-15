import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zxs666
 * @date 2020/12/4 18:19
 */
public class Num_1657 {
    public boolean closeStrings(String word1, String word2) {
        Set<Character> set1=new HashSet<>();
        Set<Character> set2=new HashSet<>();
        if(word1.length()!=word2.length())
            return false;
        int[] count1=new int[26];
        int[] count2=new int[26];
        for(char c:word1.toCharArray()){
            count1[c-'a']++;
            set1.add(c);
        }


        for(char c:word2.toCharArray()){
            count2[c-'a']++;
            set2.add(c);
        }

      for(char c:set1){
          if(!set2.contains(c))
              return false;
      }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for(int i=0;i<count1.length;i++){
            if(count1[i]!=count2[i])
                return false;
        }
        return true;


    }
}
