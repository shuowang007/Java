package pdd;

import java.util.Scanner;

public class Bag {
    public static void main(String[] args) {
        // 输入
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            // 计算需要组成多少钱
            int num = 1024 - scan.nextInt();
            // dp[i] 状态定义为找i元钱，需要的最少张数，从 0 - num 总共 num + 1种
            int[] dp = new int[num + 1];
            // 初始化dp数组，因为要找最小值，这里给每个位置赋最大值，即都是由1元组成的，即num/1
            for (int i = 0; i < dp.length; i++) {
                dp[i] = i;
            }
            // 定义钱的集合，方便遍历
            int[] money = {1, 4, 16, 64};

            // 状态转移方程 从 1 ~ num
            for (int i = 1; i <= num ; i++) {
                // dp[num]的最小值就是能组成它的前一步 + 1 和 本身进行比较
                for (int j = 0; j < money.length; j++) {
                    if (i - money[j] >= 0){
                        dp[i] = Math.min(dp[i - money[j]] + 1, dp[i]);
                    }
                }
            }

            System.out.println(dp[num]);
        }
    }
}