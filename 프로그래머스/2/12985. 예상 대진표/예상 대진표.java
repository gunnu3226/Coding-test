class Solution {
    public static void main(String[] args) {
        System.out.println(solution(8,4,7));
    }
    public static int solution(int n, int a, int b) {
        int answer = 1;
        while(!check(a,b)) {
            answer++;
            a = nextround(a);
            b = nextround(b);
        }
        return answer;
    }
    public static boolean check(int a, int b) {
        if(a % 2 == 0) {
            if(a-1==b) {
                return true;
            }
        }else if(b % 2 == 0) {
            if(b-1==a) {
                return true;
            }
        }
        return false;
    }

    public static int nextround(int n) {
        if(n % 2 ==0) {
            return n/2;
        } else{
            return (n+1)/2;
        }
    }
}