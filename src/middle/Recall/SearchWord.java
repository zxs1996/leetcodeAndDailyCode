package middle.Recall;

/**
 * Created by zxs666 on 2019/12/27.
 * 单词搜索
 */
public class SearchWord {
    char[] chars;
    char[][] board2;
    int max;
    int index = 0;
    int[] x = new int[]{0, 0, 1, -1};
    int[] y = new int[]{1, -1, 0, 0};
    int columnLength;
    int rowLength;

    public boolean exist(char[][] board, String word) {
        columnLength = board.length;
        rowLength = board[0].length;
        board2 = board;
        max = word.length();
        chars = word.toCharArray();
        for (int i = 0; i < columnLength; i++)
            for (int j = 0; j < rowLength; j++) {
                if (chars[index] == board[i][j]) {
                    index++;
                }

            }
        return true;
    }

    public boolean backTrace( int xx, int yy) {
        if (index == max)
            return true;
        for (int i = 0; i < 4; i++) {
            xx += x[i];
            yy += y[i];
            if (xx >= 0 &&xx<columnLength&&yy>=0&&yy<rowLength&&chars[index]==board2[xx][yy]){
                index++;
                if(backTrace(xx,yy))
                    return true;
            }
        }
        return false;
    }

}
