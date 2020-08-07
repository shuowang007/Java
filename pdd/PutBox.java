package pdd;

import java.util.Scanner;

/*
小易有一个体积巨大的货物，具体来说，是个在二维平面上占地的货物。
小易有一个的广场，想把货物放在这个广场上。不幸的是，广场上已经有了一些障碍物，障碍物所在的格子不能放置你的货物。小易现在想知道能否成功地放置货物。
 */
public class PutBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//组数
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();//广场宽
            int m = sc.nextInt();//广场长
            int k = sc.nextInt();//障碍物个数
            int[][] grid = new int[n+10][m+10];
            for (int j = 0; j < k; j++) {
                grid[sc.nextInt()][sc.nextInt()] = 1;
            }
            for (int row = 1; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    grid[row][col] += grid[row - 1][col] + grid[row][col-1] - grid[row-1][col-1];
                }
            }
            int c = sc.nextInt();//货物宽
            int d = sc.nextInt();//货物长
            boolean pos = false;
            for (int row = 1; row < n - c + 1; row++) {
                for (int col = 1; col < m - d + 1; col++) {
                    int ok = grid[row + c -1][col + d - 1] - grid[row + c -1][col - 1] - grid[row - 1][col + d - 1];
                    if (ok == 0){
                        System.out.println("YES");
                        pos = true;
                        break;
                    }
                }
                if (pos) break;
            }
            if (!pos) System.out.println("NO");
        }
    }
}
