package pdd;

import java.util.List;
import java.util.Scanner;

public class Box {
    public static int Solution(int n){

        int res = 0;
        while (n>0){
            n >>= 1;
            Math.max(1,2);
            res += 1;
        }
        return res;
    }
}
