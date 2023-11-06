
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int H;
    static int W;
    static String[][] arr;
    static int[] location;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            H = sc.nextInt();
            W = sc.nextInt();
            arr = new String[H][W];
            location = new int[2];

            for (int i = 0; i < H; i++) {
                arr[i] = sc.next().split("");
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (arr[i][j].equals("^") || arr[i][j].equals("v") || arr[i][j].equals("<") || arr[i][j].equals(
                            ">")) {
                        location[0] = i;
                        location[1] = j;
                    }
                }
            }

            int N = sc.nextInt();
            String[] key = new String[N];
            key = sc.next().split("");

            for (int i = 0; i < N; i++) {
                if (key[i].equals("U") || key[i].equals("D") || key[i].equals("L") || key[i].equals("R")) {
                    move(key[i]);
                } else {
                    shoot();
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void move(String key) {
        if (key.equals("U")) {
            up();
        } else if (key.equals("D")) {
            down();
        } else if (key.equals("L")) {
            left();
        } else if (key.equals("R")) {
            right();
        }
    }

    public static void up() {
        if (location[0] > 0 && !arr[location[0] - 1][location[1]].equals("#") && !arr[location[0]
                - 1][location[1]].equals("*") && !arr[location[0] - 1][location[1]].equals("-")) {
            arr[location[0]][location[1]] = ".";
            location[0]--;
            arr[location[0]][location[1]] = "^";
        } else {
            arr[location[0]][location[1]] = "^";
        }
    }

    public static void down() {
        if (location[0] < H - 1 && !arr[location[0] + 1][location[1]].equals("#") && !arr[location[0]
                + 1][location[1]].equals("*") && !arr[location[0] + 1][location[1]].equals("-")) {
            arr[location[0]][location[1]] = ".";
            location[0]++;
            arr[location[0]][location[1]] = "v";
        } else {
            arr[location[0]][location[1]] = "v";
        }
    }

    public static void left() {
        if (location[1] > 0 && !arr[location[0]][location[1] - 1].equals("#") && !arr[location[0]][location[1]
                - 1].equals("*") && !arr[location[0]][location[1] - 1].equals("-")) {
            arr[location[0]][location[1]] = ".";
            location[1]--;
            arr[location[0]][location[1]] = "<";
        } else {
            arr[location[0]][location[1]] = "<";
        }
    }

    public static void right() {
        if (location[1] < W - 1 && !arr[location[0]][location[1] + 1].equals("#") && !arr[location[0]][location[1]
                + 1].equals("*") && !arr[location[0]][location[1] + 1].equals("-")) {
            arr[location[0]][location[1]] = ".";
            location[1]++;
            arr[location[0]][location[1]] = ">";
        } else {
            arr[location[0]][location[1]] = ">";
        }
    }

    public static void shoot() {
        if (arr[location[0]][location[1]].equals("<")) {
            for (int i = location[1]; i >= 0; i--) {
                if (arr[location[0]][i].equals("#")) {
                    break;
                } else if (arr[location[0]][i].equals("*")) {
                    arr[location[0]][i] = ".";
                    break;
                }
            }
        }
        if (arr[location[0]][location[1]].equals(">")) {
            for (int i = location[1]; i < W; i++) {
                if (arr[location[0]][i].equals("#")) {
                    break;
                } else if (arr[location[0]][i].equals("*")) {
                    arr[location[0]][i] = ".";
                    break;
                }
            }
        }
        if (arr[location[0]][location[1]].equals("^")) {
            for (int i = location[0]; i >= 0; i--) {
                if (arr[i][location[1]].equals("#")) {
                    break;
                } else if (arr[i][location[1]].equals("*")) {
                    arr[i][location[1]] = ".";
                    break;
                }
            }
        }
        if (arr[location[0]][location[1]].equals("v")) {
            for (int i = location[0]; i < H; i++) {
                if (arr[i][location[1]].equals("#")) {
                    break;
                } else if (arr[i][location[1]].equals("*")) {
                    arr[i][location[1]] = ".";
                    break;
                }
            }
        }
    }
}