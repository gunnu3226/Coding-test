import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int tc = 1; tc <= T; tc++){
			int recent = sc.nextInt();
			int next = sc.nextInt();
			if(recent+next<24) {
				System.out.println("#"+tc+" "+(recent+next));
			}else {
				System.out.println("#"+tc+" "+(recent+next)%24);
			}
		}
	}
}
