import java.util.*;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>();
        Map<String, Set<String>> reportedBy = new HashMap<>();

        // 맵과 reportedBy 초기화
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
            reportedBy.put(id_list[i], new HashSet<>());
        }

        int[] reportCount = new int[id_list.length];

        // 신고 기록 수집
        for (String r : report) {
            String[] reportSplit = r.split(" ");
            String reporter = reportSplit[0];
            String targetUser = reportSplit[1];

            // 동일한 신고자에 의해 이미 신고되지 않은 경우
            if (reportedBy.get(targetUser).add(reporter)) {
                reportCount[map.get(targetUser)]++;
            }
        }

        // 확인 및 답변 업데이트
        for (int i = 0; i < reportCount.length; i++) {
            if (reportCount[i] >= k) {
                Set<String> reporters = reportedBy.get(id_list[i]);
                for (String reporter : reporters) {
                    answer[map.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}
