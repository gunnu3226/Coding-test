import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            String[] arr = new String[n];

            for(int i=0; i<n; i++) {
                arr[i] = sc.next();
            }
            String[] arr1 = Arrays.copyOfRange(arr, 0, n % 2 == 0 ? n/2 : (n/2)+1);
            String[] arr2 = Arrays.copyOfRange(arr, n % 2 == 0 ? n / 2 : (n / 2) + 1, n);
            StringBuilder sb= new StringBuilder();
            
            if (n % 2 == 0) {
                for(int i=0; i<n/2; i++) {
                    sb.append(arr1[i]+" ");
                    sb.append(arr2[i]+" ");
                }
            } else {
                for(int i=0; i<=n/2; i++) {
                    if (i == n/2) {
                        sb.append(arr1[i]+" ");
                    } else {
                        sb.append(arr1[i]+" ");
                        sb.append(arr2[i]+" ");
                    }
                }    
            }
            System.out.println("#" + tc + " " + sb);
        }
    }
}