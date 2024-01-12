class Solution {
    static int cnt;
    static int[][] arr;
    static int[] dist;
    static boolean[] visited;
    public int solution(int N, int[][] road, int K) {

        cnt = 0;
        arr = new int[N + 1][N + 1];

        // 인접 행렬 초기화
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = 500001;
            }
        }

        // 인접행렬 거리값 삽입
        for (int i = 0; i < road.length; i++) {
            if(arr[road[i][0]][road[i][1]] > road[i][2]) {
                arr[road[i][0]][road[i][1]] = road[i][2];
                arr[road[i][1]][road[i][0]] = road[i][2];
            }
        }

        // 거리, 방문 배열 만들기
        dist = new int[N + 1];
        // 최댓값으로 초기화
        for (int i = 2; i < N + 1; i++) {
            dist[i] = 500001;
        }
        visited = new boolean[N + 1];
        // 첫번째 마을 체크
        visited[1] = true;

        // 다익스트라 메서드 호출
        dijkstra(N, K);

        return cnt;
    }
    // 다익스트라 메서드
    static void dijkstra(int n, int k) {
        // 0 ~ n-1 or 1 ~ n 까지 반복
        for (int i = 1; i < n; i++) {
            int min = 500001;
            int idx = 1;

            // 가장 작은 거리애 있는 인덱스값 찾기
            for (int j = 2; j <= n; j++) {
                if(!visited[j] && min > dist[j]) {
                    idx = j;
                    min = dist[j];
                }
            }

            // 방문 체크
            visited[idx] = true;

            // 돌아가는 루트가 더 빠른지 탐색
            for (int j = 2; j <= n ; j++) {
                if(dist[j] > dist[idx] + arr[idx][j]) {
                    dist[j] = dist[idx] + arr[idx][j];
                }
            }
        }

        // k 이하의 값 카운트
        for (int i = 1; i <= n ; i++) {
            if(dist[i] <= k) {
                cnt++;
            }
        }
    }
}