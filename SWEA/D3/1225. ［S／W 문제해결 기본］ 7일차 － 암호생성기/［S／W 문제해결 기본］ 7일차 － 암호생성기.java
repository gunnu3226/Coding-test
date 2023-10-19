import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution{
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=0;i<8;i++) {
				queue.add(sc.nextInt());
			}
			
			int value = -1;
			while(value!=0) {
				for(int i=1;i<6;i++) {
					value = queue.poll();
					value -= i;
					if(value<=0) {
						value = 0;
					}
					queue.offer(value);
					if(value==0) break;
				}
			}
			System.out.print("#"+t);
			for(int j=0;j<8;j++) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
		}
	}
}