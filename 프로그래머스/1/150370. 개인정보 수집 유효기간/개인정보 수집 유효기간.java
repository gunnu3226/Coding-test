import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = { };
        List<Integer> notValidList = new ArrayList<>();

        // 현재 날짜를 Date 객체로 변환
        Date date = new Date(today);

        // 약관 종류별 유효 기간을 저장할 Map 자료형
        Map<String, Integer> typeAndValidDateMap = new HashMap<>();

        // 약관 종류별 유효 기간 저장
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            typeAndValidDateMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        int number = 1;

        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");

            Date currentDate = new Date(splitPrivacy[0]);
            Integer month = typeAndValidDateMap.get(splitPrivacy[1]);

            currentDate.addMonth(month);

            if (!currentDate.isValidFromToday(date)) {
                notValidList.add(i + 1);
            }
        }

        return notValidList.stream()
                .mapToInt(e -> e)
                .toArray();
    }
}
class Date {

    int year;
    int month;
    int day;

    public Date(String string) {
        String[] splitToday = string.split("\\.");

        year = Integer.parseInt(splitToday[0]);
        month = Integer.parseInt(splitToday[1]);
        day = Integer.parseInt(splitToday[2]);
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void addMonth(int month) {

        int year = month / 12;
        month %= 12;

        if (year > 0) {
            this.year += year;
        }

        this.month += month;

        if (this.month > 12) {
            this.year++;
            this.month =  this.month % 13 + 1;
        }
    }

    public boolean isValidFromToday(Date today) {

        boolean result;

        if (this.year == today.year) {
            if (this.month == today.month) {
                result = this.day > today.day;
            } else {
                result = this.month > today.month;
            }
        } else {
            result = this.year > today.year;
        }

        return result;
    }
}