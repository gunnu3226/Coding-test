import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution{
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int sum = 0;
			int start = n/2;
			int end = n/2;
					
			for(int i=0;i<n;i++) {
				String str = sc.next();
				for(int j=0;j<n;j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
				if(i<n/2) {
					for(int k=start;k<=end;k++) {
						sum += arr[i][k];
					}
					start -= 1;
					end += 1;
				}else {
					for(int l=start;l<=end;l++) {
						sum += arr[i][l];
					}
					start += 1;
					end -= 1;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}