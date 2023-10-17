import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			String S = sc.next();
			String sub1 = S.substring(0,N/2);
			String sub2 = S.substring(N/2,N);
			if(sub1.equals(sub2)) {
				System.out.println("#"+test_case+" Yes");
			} else {
				System.out.println("#"+test_case+" No");
			}
		}
	}
}