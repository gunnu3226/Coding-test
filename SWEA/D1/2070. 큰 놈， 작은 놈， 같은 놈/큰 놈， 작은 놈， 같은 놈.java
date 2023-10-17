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
			if(num1>num2) {
				System.out.println("#"+test_case+" >");
			}else if(num1<num2) {
				System.out.println("#"+test_case+" <");
			}else if(num1==num2) {
				System.out.println("#"+test_case+" =");
			}
		}
	}
}