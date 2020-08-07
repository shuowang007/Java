package pdd;

import java.util.Scanner;

/**
 * 小易是班级的英语课代表, 他开发了一款软件开处理他的工作。
 * 小易的软件有一个神奇的功能，能够通过一个百分数来反应你的成绩在班上的位置。“成绩超过班级 ...% 的同学”。
 * 设这个百分数为 p，考了 s 分，则可以通过以下式子计算得出 p：
 * p = ( 分数不超过 s 的人数 - 1)  班级总人数
 * 突然一天的英语考试之后，软件突然罢工了，这可忙坏了小易。成绩输入这些对于字写得又快又好的小易当然没有问题，但是计算这些百分数……这庞大的数据量吓坏了他。
 * 于是他来找到你，希望他编一个程序模拟这个软件：给出班级人数 n，以及每个人的成绩，请求出某几位同学的百分数。
 *
 *
 * 第一行一个整数 n，表示班级人数。
 * 第二行共 n 个自然数，第 i 个数表示第 i 位同学的成绩。
 * 第三行一个整数 q，表示询问的次数。
 * 接下来 q 行，每行一个数 x，表示询问第 x 位同学的百分数。
 */
public class Grades {
    public static int moreThan(int[] nums, int i){
        int point = nums[i - 1];
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= point) count++;
        }
        return --count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int query = sc.nextInt();
        for (int i = 0; i < query; i++) {
            int index = sc.nextInt();
            double ans = moreThan(nums,index)*1.0/n*100;
            System.out.printf("%.6f",ans);
            System.out.println();

        }
    }
}