import java.util.Scanner;

public class Solution {
	public static String[] arr;
	public static int max = 0;
	public static int chance = 0;
	
	public static void dfs(int k, int cnt) {
		if(cnt==chance) {
			String sb = "";
			for(String i : arr) {
				sb+=i;
			}
			max = Math.max(max, Integer.parseInt(sb.toString()));
			return;
		}
		
		for(int i=k;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
					String temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
					dfs(i,cnt+1);
					
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1 ; test_case <= T ; test_case++) {
            max = 0;
            String num = sc.next();
            chance = sc.nextInt();
            arr = num.split("");
            if(arr.length < chance) {	// swap 횟수가 자릿수보다 클 때
            	chance = arr.length;	// 자릿수만큼만 옮겨도 전부 옮길 수 있음
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
        return;
    }
}
