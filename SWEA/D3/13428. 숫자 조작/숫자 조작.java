import java.util.Scanner;

class Solution {
    static String[] arr;
    static String str;
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            str = sc.next();
            arr = str.split("");
            int max = Integer.parseInt(str);
            int min = Integer.parseInt(str);

            for(int i=0; i<arr.length-1; i++){
                for(int j=1; j<arr.length; j++) {
                    if(i==0 && arr[j].equals("0")) {
                        continue;
                    } else{
                        String save = arr[i];
                        arr[i] = arr[j];
                        arr[j] = save;
                        String cnt = "";
                        for(int k=0;k<arr.length; k++){
                            cnt += arr[k];
                        }
                        if(Integer.parseInt(cnt) > max) {
                            max = Integer.parseInt(cnt);
                        }
                        if(Integer.parseInt(cnt) < min) {
                            min = Integer.parseInt(cnt);
                        }
                        arr[j] = arr[i];
                        arr[i] = save;
                    }

                }
            }
            System.out.println("#"+test_case+" "+min+" "+max);
        }
    }
}