package DP;

public class MinimumMatrixPath {
    /**
     * M*N的矩阵, 只能向下/向右走
     * 求从(0, 0) 走到 (i, j)的最短路径和
     *
     * dp[i][j] = m[i][j] + min(dp[i-1][j], dp[i][j-1]);
     *
     */

    public int findWay(int[][] m, int destI, int destJ){
        int[][] dp = new int[m.length][m[0].length];
        //dp第一行的值就是m的第一行对应位置的累加和
        for (int i = 1; i < m[0].length; i ++){
            dp[0][i] = m[0][i] + m[0][i-1];
        }
        //dp第一列的值就是m的第一列对应位置的累加和
        for (int j = 1; j < m.length; j ++){
            dp[j][0] = m[j][0] + m[j-1][0];
        }
        for (int i = 1; i <= destI; i ++){
            for (int j = 1; j <= destJ; j ++){
                dp[i][j] = m[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[destI][destJ];
    }

    public static void main(String[] args) {
        int[][] m = new int[4][];
        m[0] = new int[]{1, 3, 5, 9};
        m[1] = new int[]{8, 1, 3, 4};
        m[2] = new int[]{5, 0, 6, 1};
        m[3] = new int[]{8, 8, 4, 0};

        MinimumMatrixPath s = new MinimumMatrixPath();
        int res = s.findWay(m, 3, 3);
        System.out.println(res);
    }
}
