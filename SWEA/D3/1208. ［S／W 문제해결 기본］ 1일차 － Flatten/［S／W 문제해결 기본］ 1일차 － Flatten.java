import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();

        for(int tc = 1; tc <= 10; tc++){
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<100; i++) {
                list.add(sc.nextInt());
            }
            for(int j=0; j<n; j++) {
                int maxIndex = list.indexOf(Collections.max(list));
                int minIndex = list.indexOf(Collections.min(list));

                list.set(maxIndex, list.get(maxIndex)-1);
                list.set(minIndex, list.get(minIndex)+1);
            }
            System.out.println("#"+tc+" "+(Collections.max(list)-Collections.min(list)));
        }
    }
}