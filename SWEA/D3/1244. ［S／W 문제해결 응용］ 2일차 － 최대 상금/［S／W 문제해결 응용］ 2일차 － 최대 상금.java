import java.util.Scanner;

class Solution {
    
    static int n, max;
    static String[] arr;
    
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            arr = sc.next().split("");
            n = sc.nextInt();
            max = 0;
            
            if(n > arr.length) {
                n = arr.length;
            }
            dfs(0);
            System.out.println("#"+tc+" "+max);
        }
    }
    
    public static void dfs(int cnt) {
        if(cnt == n) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<arr.length; i++) {
                sb.append(arr[i]);
            }
            if(max < Integer.parseInt(sb.toString())) {
                max = Integer.parseInt(sb.toString());
            }
            return;
        }
        
        for(int i=0; i< arr.length; i++) {
            for(int j=i+1; j< arr.length; j++) {
                String a = arr[i];
                arr[i] = arr[j];
                arr[j] = a;
                dfs(cnt + 1);
                
                arr[j] = arr[i];
                arr[i] = a;
            }
        }
    }
}