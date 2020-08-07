package pdd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
小易有一个初始为空的数字集合，支持两种操作：
1、加入数字x到集合中。
2、询问集合中是否存在一个子集，满足子集中所有数字的Or值恰好为k。
Or为二进制按位或操作，C++中表示为"|"。
小易希望你能解决这个问题。

第一行数字q,表示操作个数
接下来q行，每行两个数字：
1 x表示插入数字x
2 x表示询问数字x(即题设中询问的数值k)
 */
public class Or {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        while (q-- > 0){
            int flag = sc.nextInt();
            int target = sc.nextInt();
            if (flag == 1){
                set.add(target);
            }else {
                int temp = 0;
                for (Integer each: set){
                    if ((each | target) == each){
                        temp |= each;
                    }
                }
                if (temp == target){
                    System.out.println("YES");
                    set.add(target);
                }else {
                    System.out.printf("NO");
                }
            }
        }
    }
}
