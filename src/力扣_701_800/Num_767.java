package 力扣_701_800;

/**
 * @author zxs666
 * @date 2020/11/30 15:28
 * <p>
 * 贪心算法，每轮找当前和前一个不重复的剩余最多的符号
 * 比如当前选择了a 剩余为aaaaabbbcc,那么选择b
 */
public class Num_767 {

    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        int preIndex = -1;//初始为-1，一定能找打一个
        for (int i = 0; i < S.length(); i++) {
            //找应该填入的字符
            int cur = findMax(preIndex, count);
            //如果找到的字符计数为0，那么说明不能重构
            if (count[cur] == 0)
                return "";
            //否则将字符加到StringBuilder上
            sb.append((char) (cur + 'a'));
            count[cur]--;//字符计数--
            preIndex = cur;//更新preIndex
        }
        return sb.toString();
    }

    public int findMax(int preIndex, int[] count) {
        int max = 0;//记录起始的max位置
        if (preIndex == 0)//如果preIndex为0，那么max设置为1
            max = 1;
        for (int j = max; j < 26; j++) {
            //如果和前一个字符相同或者计数为1，那么continue
            if (j == preIndex||count[j] == 0)
                continue;
            //更新max值

            if (count[j] > count[max])
                max = j;
        }
        return max;
    }
}
