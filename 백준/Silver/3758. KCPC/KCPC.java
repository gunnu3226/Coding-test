import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); //팀의개수
            int k = Integer.parseInt(st.nextToken()); //문제개수
            int t = Integer.parseInt(st.nextToken()); //내가 구해야하는 팀id
            int m = Integer.parseInt(st.nextToken()); //로그엔트리 개수

            //int[teamId][problemId] = score 팀별 문제의 점수
            //int[teamId] = count 팀의 풀이 제출 횟수
            //int[teamId] = 마지막 제출 인덱스

            int[][] scores = new int[n + 1][k + 1];
            int[] counts = new int[n + 1];
            int[] lastIdx = new int[n + 1];

            for(int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                scores[teamId][problemId] = Math.max(scores[teamId][problemId], score);
                counts[teamId]++;
                lastIdx[teamId] = i;
            }

            //각 팀의 문제 점수의 합
            int[] scoreSum = new int[n + 1];
            for(int i=1; i <= n; i++) {
                for(int j=1; j <= k; j++) {
                    scoreSum[i] += scores[i][j];
                }
            }

            //같은 점수를 가진 팀id 리스트
            List<Integer> sameScoreTeam = new ArrayList<>();
            int rank = 1;
            for(int i=1; i<=n; i++) {
                if (i == t) continue;
                if (scoreSum[t] < scoreSum[i]) rank++;
                else if (scoreSum[t] == scoreSum[i]) sameScoreTeam.add(i);
            }

            //같은 점수를 가진 팀이 있다면
            if (!sameScoreTeam.isEmpty()) {
                //같은 제출횟수 팀id 리스트
                List<Integer> sameCountsTeam = new ArrayList<>();
                for (Integer teamId : sameScoreTeam) {
                    //내 팀보다 제출 횟수가 적은 팀이 존재하면 등수 내려감;
                    if (counts[teamId] < counts[t] ) {
                        rank++;
                    //같은 점수에 제출 횟수까지 같다면 리스트에 추가
                    } else if (counts[teamId] == counts[t]) {
                        sameCountsTeam.add(teamId);
                    }
                }
                //점수와 제출횟수 모두 같은 팀이 있다면
                if (!sameCountsTeam.isEmpty()) {
                    for(Integer teamId : sameCountsTeam) {
                        //최종 제출 순서가 더 빠른팀이 있다면 등수 내려감
                        if (lastIdx[teamId] < lastIdx[t]) {
                            rank++;
                        }
                    }
                }
            }
            System.out.println(rank);
        }
    }
}
