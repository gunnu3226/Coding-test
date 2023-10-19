import java.util.Scanner;

class Solution{
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			int[][] arr = new int[100][100];
			int dia_sum = 0;
			int inversedia_sum = 0;
			int best = 0;
			
			for(int i=0;i<100;i++) {
				int row_sum = 0;
				for(int j=0;j<100l;j++) {
					arr[i][j] = sc.nextInt();
					row_sum +=arr[i][j];
				}
				if(row_sum>best) {
					best = row_sum;
				}
			}
			
			for(int j=0; j<100;j++) {
				int col_sum = 0;
				for(int i=0;i<100;i++) {
					col_sum +=arr[i][j];
					if(j==i) {
						dia_sum += arr[i][j];
					}
				}
				if(col_sum>best) {
					best = col_sum;
				}
			}
			if(dia_sum>best) {
				best = dia_sum;
			}
			for(int l=0; l<100;l++) {
				inversedia_sum += arr[l][99-l];
			}
			if(inversedia_sum>best) {
				best = inversedia_sum;
			}
			System.out.println("#"+tc+" "+best);
			best = 0;
		}
	}
}