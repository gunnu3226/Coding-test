import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static String[][] arr;

    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new LinkedHashMap<>();
        map.put("-1",0);
        map.put("0",0);
        map.put("1",0);

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];

        for(int i=0; i<n; i++) {
            arr[i] = br.readLine().split(" ");
        }
        recursive(0,0,n);
        for (Integer value : map.values()) {
            System.out.println(value);
        }
    }

    public static void recursive(int rowStart, int colStart, int len) {
        boolean check = true;
        if(len == 1) {
            map.put(arr[rowStart][colStart], map.get(arr[rowStart][colStart])+1);
            return;
        }

        for(int i = rowStart; i < rowStart+len; i++) {
            for(int j=colStart; j<colStart+len; j++) {
                if(!arr[rowStart][colStart].equals(arr[i][j])) {
                    check = false;
                    break;
                }
            }
        }

        if (check) {
            map.put(arr[rowStart][colStart], map.get(arr[rowStart][colStart])+1);
            return;
        }

        for (int i = rowStart; i < rowStart+len; i += len/3) {
            for(int j = colStart; j < colStart+len; j += len/3) {
                recursive(i, j, len/3);
            }
        }
    }
}
