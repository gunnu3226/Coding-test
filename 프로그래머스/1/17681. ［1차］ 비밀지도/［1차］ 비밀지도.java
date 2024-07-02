class Solution {

    public static void main(String[] args) {
        solution(5, new int[]{9,20,28,18,11}, new int[]{30,1,21,17,28});
    }
    static int[][] map;

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        map = new int[n][n];
        mapping(arr1);
        mapping(arr2);

        String[] answer = new String[n];
        for(int i=0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j <n; j++) {
                if(map[i][j] == 1) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    private static void mapping(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            String line = Integer.toBinaryString(arr[i]);

            
            if(line.length() != n) {
                int addCount = n - line.length();
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<addCount; k++) {
                    sb.append("0");
                }
                line = sb.append(line).toString();
            }
            String[] strArr = line.split("");

            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) continue;
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }
    }
}
