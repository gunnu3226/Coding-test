import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return 5* cities.length;
        }
        List<String> caches = new LinkedList<>();
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if(!caches.contains(city)) {
                answer +=5;
                if(caches.size() >= cacheSize) {
                    caches.remove(0);
                }
                caches.add(city);
                continue;
            } 
            
            if(caches.contains(city)) {
                caches.remove(city);
                caches.add(city);
                answer++;
            }
        }
        return answer;
    }
}