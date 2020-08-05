package pdd;

import java.util.Scanner;
public class Energy{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int[] shu = new int[n + 1];
        shu[0] = 0;

        for(int i = 1;i < n + 1;i++){
            shu[i] = scanner.nextInt();
        }
        int e = 0;
        for(int i = n ;i >= 1;i--){
            if((e + shu[i]) % 2 != 0){
                e = (e + shu[i]) / 2 + 1;
            }
            else
                e = (e + shu[i]) / 2;

        }
        System.out.println(e);
    }
}