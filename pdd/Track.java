package pdd;

import java.util.HashMap;
import java.util.Scanner;

public class Track {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int num = scanner.nextInt();
        HashMap<String, Integer> last = new HashMap<>();
        HashMap<String, Integer> current = new HashMap<>();
        int max=0;
        for (int i = 0; i < num; i++) {
            int pairNum = scanner.nextInt();
            for (int j = 0; j < pairNum; j++) {
                String key= scanner.nextInt()+"_"+scanner.nextInt();
                if (last.get(key)==null){
                    current.put(key,1);
                }else {
                    current.put(key,last.get(key)+1);
                }
            }
            for (Integer value : current.values()) {
                max=Math.max(value,max);
            }
            last=current;
            current=new HashMap<>();
        }
        System.out.println(max);
    }
}
