public class Num_5511 {
    public int numSpecial(int[][] mat) {
        int rowFlag[] = new int[mat.length];
        int colFlag[] = new int[mat[0].length];
        int res = 0;
        //统计行
        for (int i = 0; i < mat.length; i++) {
            rowFlag[i] = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    rowFlag[i]++;

            }
        }
        for (int i = 0; i < mat[0].length; i++) {
            colFlag[i] = 0;
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 1)
                    colFlag[i]++;

            }
        }
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rowFlag[i]==1 && colFlag[j]==1)
                    res++;
            }
        return res;

    }
}
