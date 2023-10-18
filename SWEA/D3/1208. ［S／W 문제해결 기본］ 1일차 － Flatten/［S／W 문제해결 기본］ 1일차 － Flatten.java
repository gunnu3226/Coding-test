
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++){
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<100;i++) {
				list.add(sc.nextInt());
			}
			for(int j=0;j<n;j++) {
				
				int maxindex = list.indexOf(Collections.max(list));
				int minindex = list.indexOf(Collections.min(list));
				
				list.set(maxindex, list.get(maxindex)-1);
				list.set(minindex, list.get(minindex)+1);
				
				if(Collections.max(list)-Collections.min(list)<=1) {
					break;
				}
			}
			System.out.println("#"+tc+" "+(Collections.max(list)-Collections.min(list)));
		}
	}
}