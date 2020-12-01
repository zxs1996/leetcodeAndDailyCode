import com.sun.javafx.scene.NodeHelper;

import java.util.HashMap;
import java.util.Map;

public class Num_5512 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            map.put(pairs[i][0], pairs[i][1]);
            map.put(pairs[i][1], pairs[i][0]);
        }


        int unhappy = 0;
        for (int i = 0; i < pairs.length; i++) {
            for (int count = 0; count < 2; count++) {
                int friendA = pairs[i][count];
                int matchFriend = map.get(friendA);

                //从亲密度数组里面从0开始找这个配对朋友的位置
                int index = 0;
                for (; index < preferences[friendA].length; index++) {
                    if (matchFriend == preferences[friendA][index])
                        break;
                }
                //如果匹配的朋友是最亲密的，那么一定不会不开心
                if (index == 0)
                    continue;
                boolean flag = true;
                //找配对朋友前面的朋友是否不开心
                for (int j = 0; j < index && flag; j++) {
                    int moreHappy = preferences[friendA][j];
                    int moreHappyMatch = map.get(moreHappy);
                    for (int k = 0; k < preferences[moreHappy].length; k++) {
                        if (preferences[moreHappy][k] == friendA) {
                            unhappy++;
                            flag = false;
                            break;
                        } else if (preferences[moreHappy][k] == moreHappyMatch)
                            break;
                    }
                }
            }
        }
        return unhappy;
    }
}
