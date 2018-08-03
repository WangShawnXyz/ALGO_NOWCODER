package DP;

public class ChargeMoney {
//    int[] items = new int[]{1, 5, 10, 20, 100};
    int count = 0;
    public void charge(){
        int[] items = new int[]{1, 5, 10, 20, 100};
        chargeBruteForce(items, 1000, 0);
        System.out.println(this.count);
        chargeDP(items, 1000);

    }

    public void chargeBruteForce(int[] items, int aim, int itemsIndex){
        if (itemsIndex >= items.length) return;
        if (aim == 0) this.count++;
        for (int i = 0; aim - items[itemsIndex] * i >= 0; i ++){
            int remainAim = aim - items[itemsIndex] * i;
            chargeBruteForce(items, remainAim, itemsIndex + 1);
        }
    }

    public void chargeNotebook(int[] items, int aim){
        if (items == null || items.length == 0 || aim < 0) return;
        int[][] map = new int[items.length + 1][aim + 1];
        this.count = 0;

    }
    private int notebook(){
        return 0;
    }

    public void chargeDP(int[] items, int aim){
         int[][] dp = new int[items.length][aim + 1];
        /**
         * dp[i][j] 的含义是 在使用 items[i]的情况下 组成总钱数为j的方法数
         *  *特别的 对于第0列 dp[i][0] 的含义是, 用items[i]面值的钱组成总钱数为0的方法数目,
         *      显然只有一种, 即0张该面值的钱, 所以初始化为1
         */
        for (int i = 0; i < items.length; i ++){
             dp[i][0] = 1;
        }
        /**
         * 对于第0行, dp[0][j]的含义是只用items[0]这种货币组成总钱数为j的方法数目
         *   *显然, 只有j能被items[0]整除时才有一种组合方法, 所以j能被items[0]整除的
         *      dp[0][j]值为1,其余为0
         */
        for (int j = 0; j < aim+1; j ++){
            if (j % items[0] == 0){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }
        /**
         * 对于一般情况的dp[i][j]的值由以下规则来求
         * dp[i][j]的值由以下情况累加
         * *1. 如果完全不用items[i]面值的货币, 只使用items[0..i-1]的货币构成时,
         *      方法数为 dp[i-1][j (- 0*items[i])]
         * *2. 如果使用1张items[i]面值的货币, 剩下的钱用items[0..i-1]构成时,
         *      方法数为 dp[i-1][j - 1*items[i]]
         * *3. 如果使用2张items[i]面值的货币, 剩下的钱用items[0..i-1]构成时,
         *      方法数为 dp[i-1][j - 2*items[i]]
         *      ......
         * *k. 如果使用k张items[i]面值的货币, 剩下的钱用items[0..i-1]构成时,
         *      方法数为 dp[i-1][j - k*items[i]]
         *      ......
         *
         * *由以上过程可以看出, 计算的顺序是先由做到右求一行的值, 再由上到下求各行的值.
         * 最终的计算结果就是dp[i][j]的值
         */

        for (int i = 1; i < items.length; i ++){
            for (int j = 1; j <= aim; j ++){
                if (j - items[i] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j - items[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[items.length-1][aim]);
    }

    public static void main(String[] args) {
        ChargeMoney s = new ChargeMoney();
        s.charge();
    }
}
