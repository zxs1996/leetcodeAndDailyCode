package 力扣_1_100;

/**
 * Created by zxs666 on 2020/7/15.
 * 搜索二维矩阵，两次二分搜索
 */
public class Num_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;//行
        int n = matrix[0].length;//列
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
            return false;
        int l = 0, r = m - 1;
        //先搜索行
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        //对l做一个限制
        if (matrix[l][0] > target)
            --l;
        int key = l;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[key][mid] == target)
                return true;
            else if (matrix[key][mid] < target)
                l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

}
