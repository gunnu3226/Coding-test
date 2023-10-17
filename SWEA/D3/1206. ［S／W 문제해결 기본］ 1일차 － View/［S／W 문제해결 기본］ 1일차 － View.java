import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		for(int tc = 1; tc <= 10; tc++){
			int N = sc.nextInt();
			int[] buildings = new int[N];
			for(int i=0;i<N;i++) {
				buildings[i]=sc.nextInt();
			}
			for(int j=2;j<N-2;j++){
				if(buildings[j]>Math.max(Math.max(buildings[j-2], buildings[j-1]),Math.max(buildings[j+1], buildings[j+2]))) {
					answer+=buildings[j]-Math.max(Math.max(buildings[j-2], buildings[j-1]),Math.max(buildings[j+1], buildings[j+2]));
				}
			}
			System.out.println("#"+tc+" "+answer);
			answer = 0;
		}
	}
}
