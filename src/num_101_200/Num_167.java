package num_101_200;

/**
 * Created by zxs666 on 2020/7/29.
 * //两数之和
 */
public class Num_167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target)
                return new int[]{index1 + 1, index2 + 1};
            else if (numbers[index1] + numbers[index2] < target)
                index1++;
            else
                index2--;
        }
        return null;

    }
}
