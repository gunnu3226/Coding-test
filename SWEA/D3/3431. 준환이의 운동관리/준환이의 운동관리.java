import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++){
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int num3 = sc.nextInt();
			if(num3>num2) {
				System.out.println("#"+test_case+" "+-1);
			}else if(num3>=num1&&num3<=num2) {
				System.out.println("#"+test_case+" "+0);
			}else if(num3<num1) {
				System.out.println("#"+test_case+" "+(num1-num3));
			}
		}
	}
}
