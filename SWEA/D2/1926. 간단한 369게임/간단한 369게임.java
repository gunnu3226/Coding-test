import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = sc.nextInt();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++) {
            String str = Integer.toString(i);
            if(str.contains("3") ||
                str.contains("6") ||
                str.contains("9")
            ) {
                str = str.replace('3', '-');
                str = str.replace('6', '-');
                str = str.replace('9', '-');
                str = str.replaceAll("[0-9]", "");
                sb.append(str+" ");
            } else{
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
//        for(int tc = 1; tc <= 10; tc++){
//            int n = sc.nextInt();
//
//        }
    }
}