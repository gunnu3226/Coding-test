import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flowers.add(new Flower(startMonth, startDay, endMonth, endDay));
        }


        //시작일이 빠른 순서, 두번 째 기준은 종료일이 느린 순서
        Collections.sort(flowers, (o1, o2) -> {
            if (o1.startMonth != o2.startMonth) {
                return o1.startMonth - o2.startMonth;
            }
            if (o1.startDay != o2.startDay) {
                return o1.startDay - o2.startDay;
            }
            if (o1.endMonth != o2.endMonth) {
                return o2.endMonth - o1.endMonth;
            }
            return o2.endDay - o1.endDay;
        });

        int currentEndMonth = 3;
        int currentEndDay = 1;
        int nextEndMonth = 0;
        int nextEndDay = 0;
        int index = 0;
        int count = 0;

        while (currentEndMonth < 12) {
            boolean found = false;

            for (; index < N; index++) {
                Flower flower = flowers.get(index);

                if ((flower.startMonth < currentEndMonth) || (flower.startMonth == currentEndMonth && flower.startDay <= currentEndDay)) {
                    if ((flower.endMonth > nextEndMonth) || (flower.endMonth == nextEndMonth && flower.endDay > nextEndDay)) {
                        nextEndMonth = flower.endMonth;
                        nextEndDay = flower.endDay;
                        found = true;
                    }
                } else {
                    break;
                }
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            currentEndMonth = nextEndMonth;
            currentEndDay = nextEndDay;
            count++;
        }
        if (currentEndMonth == 12) {
            System.out.println(count);
        } else {
            System.out.println(0);   
        }
    }
}

class Flower {
    int startMonth;
    int startDay;
    int endMonth;
    int endDay;

    public Flower(int startMonth, int startDay, int endMonth, int endDay) {
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
    }
}
