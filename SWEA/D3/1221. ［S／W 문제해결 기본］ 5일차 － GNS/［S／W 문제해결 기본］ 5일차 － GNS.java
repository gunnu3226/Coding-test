import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            Map<String, Integer> map = new LinkedHashMap<>();
            map.put("ZRO", 0);
            map.put("ONE", 0);
            map.put("TWO", 0);
            map.put("THR", 0);
            map.put("FOR", 0);
            map.put("FIV", 0);
            map.put("SIX", 0);
            map.put("SVN", 0);
            map.put("EGT", 0);
            map.put("NIN", 0);

            String a = sc.next();
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<n; i++) {
                String num = sc.next();
                map.put(num, map.get(num) + 1);
            }

            for (String s : map.keySet()) {
                for(int i=0; i<map.get(s); i++) {
                    sb.append(s+" ");
                }
            }
            System.out.println("#"+tc);
            System.out.println(sb);
        }
    }
}