import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    static HashMap<String,Integer> inTimeRecords;
    static Map<String,Integer> totolTimes;

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees,records);
    }

    public static int[] solution(int[] fees, String[] records) {
        inTimeRecords = new HashMap<>();
        totolTimes = new TreeMap<>();

        for(int i=0; i<records.length; i++) {
            String[] splits = records[i].split(" ");
            if(splits[2].equals("IN")) {
                parkIn(splits[0],splits[1]); //입차
            } else if(splits[2].equals("OUT")) {
                parkOut(splits[0],splits[1]); //출차
            }
        }
        if(!inTimeRecords.isEmpty()) {
            for(String key : inTimeRecords.keySet()) {
                totolTimes.put(key,totolTimes.getOrDefault(key,0) + minuteChange("23:59") - inTimeRecords.get(key));
            }
        }
        List<Integer> list = new ArrayList<>();
        for(String carNumber : totolTimes.keySet()) {
            list.add(parkingFee(fees, totolTimes.get(carNumber)));
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static int minuteChange(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }

    public static void parkIn(String time, String carNumber) {
        int inTime = minuteChange(time);
        inTimeRecords.put(carNumber,inTime);
    }

    public static void parkOut(String time, String carNumber) {
        totolTimes.put(carNumber,totolTimes.getOrDefault(carNumber,0) + minuteChange(time) - inTimeRecords.get(carNumber));
        inTimeRecords.remove(carNumber);
    }

    public static int parkingFee(int[] fees, int time) {
        if(time < fees[0]) {
            return fees[1]; //기본요금 상황
        }
        //기본요금 + 단위요금 * (추가시간 + (단위시간-1))/단위시간)
        int fee = fees[1] + (((time-fees[0]) + (fees[2]-1))/fees[2]) * fees[3];
        return fee;
    }
}

//1.record를 공백을 기준으로 split하면 0:입차시간, 1:차번호, 3:입출차
//0저장할 때 아예 분으로 바꿔서 저장
//0을 :을 기준으로 스플릿해서 split[0]*60 + split[1] = 분으로 나옴.
//2. 3="IN"이면 입차 프로세스 가동
//      - 차 번호를 set에 넣어준다.
//      - set에 넣기 성공시 totalmap에 <차번호,0>입력
//      - 차 번호와 시간을 map에 저장<차번호,시간(분)>
//3. 3="OUT"이면 출차 프로세스 가동
//      -차번호를 key값으로 입차시간을 찾아서 현재 시간에서 빼서 recordTotalTime map에 저장
//      -inTimeRecord맵에 해당 값 삭제
//
//4. intimeRecord맵에 차량이 남아있을 시 23:59분에 출차로 출차프로세스처리.
//5. set을 sort한 후 차례대로 돌면서 맵에서 요금을 받아와(요금계산 메소드) result를 생성한다.