
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            String[] arr = sc.next().split("");
            List<String> list = new ArrayList<>(Arrays.asList(arr));

            while (samenum(list)) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(list.get(i + 1))) {
                        list.remove(i);
                        list.remove(i);
                        break;
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                answer.append(list.get(i));
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static boolean samenum(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return true;
            }
        }
        return false;
    }
}