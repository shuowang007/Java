package pdd;

import java.util.Scanner;

/**
 * 回溯法
 */
public class QueHun {


    private static int[] arr = new int[13];
    private static int[] count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        count = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            ++count[arr[i]-1];
        }


        int winCount = 0;
        // 选择1到9中的一个作为第14张牌，然后判断是否胡牌
        for (int i = 1 ; i <= 9; i++) {
            if(count[i-1]<4){
                ++count[i-1];
                if(win()){
                    ++winCount;
                    System.out.print(i);
                    System.out.print(" ");
                }
                --count[i-1];
            }
        }
        if(winCount==0){
            System.out.println(0);
        }
    }
    public static boolean win(){
        // 从1到9 中选择一个作为雀头, 然后判断剩余的牌是否构成4对
        for (int i = 1; i <= 9; i++) {
            if(count[i-1]<2){
                continue;
            }
            count[i-1]-=2;
            if(hasTriples(4)){
                count[i-1]+=2;
                return true;
            }
            count[i-1]+=2;
        }
        return false;
    }

    public static boolean hasTriples(int n){
        if(n==0){
            return true;
        }
        // 1到9，每一张牌尝试三张或顺子
        for (int i = 1; i <= 9; i++) {
            if(count[i-1]>=3){
                count[i-1]-=3;
                boolean subHashTriples = hasTriples(n-1);
                count[i-1]+=3;
                if(subHashTriples){
                    return true;
                }
            }
            if(i<=7  && count[i-1]>0 && count[i] > 0 && count[i+1]>0){
                --count[i-1];
                --count[i];
                --count[i+1];
                boolean subHasTriples = hasTriples(n-1);

                ++count[i-1];
                ++count[i];
                ++count[i+1];
                if(subHasTriples){
                    return true;
                }
            }
        }
        return false;
    }
}

