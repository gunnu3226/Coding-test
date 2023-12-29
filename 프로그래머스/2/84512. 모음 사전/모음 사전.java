import java.util.ArrayList;
import java.util.List;

class Solution {
    static String[] arr = new String[]{"A","E","I","O","U"};
    static List<String> list;
    public int solution(String word) {
        list = new ArrayList<>();
        dic("",0);
        return list.indexOf(word);
    }

    public void dic(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i=0; i<5; i++) {
            dic(str + arr[i], len + 1);
        }
    }
}

//단어의 길이는 5까지
//사전 순서를 찾아라.
//1. 배열을 만든다.(a,e,i,o,u)
//2.