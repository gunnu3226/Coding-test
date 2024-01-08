import java.util.*;

class Solution {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] check;
    static List<Integer> list;
    static int[] answer;

    public static void main(String[] args) {
        solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
    }

    public static int[] solution(String[] maps) {
        int xn = maps.length;
        int yn = maps[0].length();
        check = new boolean[xn][yn];
        list = new ArrayList<>();

        String[][] map = new String[maps.length][maps[0].length()];
        //맵을 2차원 배열에 저장
        for(int i=0; i< maps.length; i++) {
            map[i] = maps[i].split("");
        }

        Queue<Location> q = new LinkedList<>();

        for(int i =0; i<xn; i++) {
            for(int j=0; j<yn; j++) {
                if(!map[i][j].equals("X")&& !check[i][j]) {
                    Location location = new Location(i,j);
                    q.add(location);
                    check[location.x][location.y] = true;
                    list.add(bfs(q,map,xn,yn));
                }
            }
        }
        if (list.size() == 0) {
            answer = new int[]{-1};
        } else {
            answer = list.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(answer);
        }
        return answer;
    }

    public static int bfs(Queue<Location> q, String[][] map,int xn, int yn) {
        int day = 0;
        while(!q.isEmpty()) {
            Location location = q.poll();
            day += Integer.parseInt(map[location.x][location.y]);
            for(int i=0; i<4; i++) {
                int cx = location.x+dx[i];
                int cy = location.y+dy[i];

                if(0<=cx && cx < xn && 0<=cy && cy < yn) {
                    if(!map[cx][cy].equals("X")&&!check[cx][cy]) {
                        Location next = new Location(cx, cy);
                        q.add(next);
                        check[cx][cy] = true;
                    }
                }
            }
        }
        return day;
    }
}


class Location {
    int x;
    int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}