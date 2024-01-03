import java.util.HashSet;
import java.util.Set;

class Solution {
    static int answer = 0;
    static boolean[] check;
    static Set<Integer> set;

    public static void main(String[] args) {
        solution("011");
    }
    public static int solution(String numbers) {
        String[] numArr = numbers.split("");
        check = new boolean[numArr.length];
        set = new HashSet<>();
        dfs(0,numbers,"");
        return set.size();
    }

    public static void dfs(int depth, String numbers, String str) {
        if(str!=""){
            if(checkPrime(str)) set.add(Integer.parseInt(str));
        }
        if(depth == numbers.length()) return;

        for(int i=0; i<numbers.length(); i++){
            if(!check[i]){
                check[i] = true;
                dfs(depth+1, numbers, str + numbers.charAt(i));
                check[i] = false;
            }
        }
    }

    public static boolean checkPrime(String num) {
        int number = Integer.parseInt(num);
        if(number < 2) return false;
        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}