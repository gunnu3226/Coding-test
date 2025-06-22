import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //int[][] 형태의 맵을 만들어 직사각형에 해당하는 좌표에 값을 채운다.
        int[][] map = new int[M][N];

        //맵의 모든 영역을 0으로 초기화
        fillZeroToMap(map, M, N);

        //직사각형이 존재하는 영역 1로 채우기
        for(int i = 0; i < K; i++) {
            fillRectangle(map, new StringTokenizer(br.readLine()));
        }

        List<Integer> answerList = new ArrayList<>();
        for(int y = 0; y < M; y++) {
            for(int x = 0; x < N; x++) {
                if(map[y][x] == 0) {
                    answerList.add(bfs(map, M, N, x, y));
                }
            }
        }

        Collections.sort(answerList);
        System.out.println(answerList.size());
        for(int i = 0; i < answerList.size(); i++) {
            System.out.print(answerList.get(i)+ " ");
        }
    }

    private static int bfs(int[][] map, int M, int N, int x, int y) {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(x,y));
        map[y][x] = -1;
        int size = 1;

        while(!q.isEmpty()) {
            Location location = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = location.x + dx[i];
                int newY = location.y + dy[i];

                if (!isOverMapLocation(new Location(newX, newY), M, N) && map[newY][newX] == 0){
                    q.add(new Location(newX, newY));
                    map[newY][newX] = -1;
                    size++;
                }
            }
        }
        return size;
    }

    private static boolean isOverMapLocation(Location location, int M, int N) {
        return (location.y < 0 || location.y >= M || location.x < 0 || location.x >= N);
    }

    //맵을 0으로 초기화
    private static void fillZeroToMap(int[][] map, int M, int N) {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = 0;
            }
        }
    }

    //맵에 직사각형에 해당하는 부분에 1을 채우는 메서드
    private static void fillRectangle(int[][] map, StringTokenizer locationInfo) {
        //왼쪽 아래 꼭짓점 좌표
        int leftX = Integer.parseInt(locationInfo.nextToken());
        int leftY = Integer.parseInt(locationInfo.nextToken());

        //오른쪽 위 꼭짓점 좌표
        int rightX = Integer.parseInt(locationInfo.nextToken());
        int rightY = Integer.parseInt(locationInfo.nextToken());

        //X 좌표는 무조건 leftX < rightX
        //Y 좌표는 무조건 leftY < rightY
        for(int y = leftY; y < rightY; y ++) {
            for(int x = leftX; x < rightX; x++) {
                map[y][x] = 1;
            }
        }
    }

    private static void debug(int[][] map) {
        int yLength = map.length;
        int xLength = map[0].length;

        for(int i=0; i<yLength; i++) {
            for(int j=0; j<xLength; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}