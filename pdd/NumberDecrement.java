package pdd;

import java.util.Arrays;
import java.util.Scanner;

/*
小易在维护数据的时候遇到一个需求，具体来说小易有一系列数据，这些数据了构成一个长度为n的数字序列，接下来小易会在这个序列上进行q次操作。
每次操作有一个查询的数字x，小易需要将序列数据中所有大于等于x的数字都减一，并输出在本次操作中有多少个数字被减一了。
小易犯了难，希望你能帮帮他。

第一行n,q，表示数字个数和操作个数。
接下来一行n个数表示初始的数字。
接下来q行，每行一个数，表示指定的数字x。
 */
public class NumberDecrement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            System.out.println(Decr(arr,x));
        }
    }
    public static int Decr(int[] arr,int x){
        int count = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] >= x){
                arr[i]--;
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}
