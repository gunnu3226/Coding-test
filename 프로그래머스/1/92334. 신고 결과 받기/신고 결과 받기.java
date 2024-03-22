import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> map = new HashMap<>();
        Map<String, Set<String>> reportBy = new HashMap<>();

        //map에 회원 인덱스 넣기
        for(int i=0; i< id_list.length; i++) {
            map.put(id_list[i],i);
            reportBy.put(id_list[i],new HashSet<>());
        }

        int[] reportCount = new int[id_list.length];
        for(String r: report) {
            String[] reportSplit = r.split(" "); //0:신고한 사람, 1:신고 당한 사람

            if (reportBy.get(reportSplit[1]).add(reportSplit[0])) {
                reportCount[map.get(reportSplit[1])]++;
            }
        }
        
        for(int i=0; i<reportCount.length; i++) {
            //기준 횟수 보다 높을 시
            if(reportCount[i]>=k) {
                //신고자 배열에 나누어 저장 후 메일 발송횟수 추가
                Set<String> reporters = reportBy.get(id_list[i]);
                for(String reporter : reporters) {
                    answer[map.get(reporter)]++;
                }
            }
        }
        return answer;
    }
}