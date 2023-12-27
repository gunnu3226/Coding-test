class Solution {
    public String solution(String s) {
        StringBuilder newstr = new StringBuilder();
        if('a'<=s.charAt(0) && s.charAt(0)<='z') {
            newstr.append(Character.toUpperCase(s.charAt(0)));
        } else {
            newstr.append(s.charAt(0));
        }
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1) == ' ') {
                newstr.append(Character.toUpperCase(s.charAt(i)));
            } else if (s.charAt(i)>'0'&& s.charAt(i)<'9') {
                newstr.append(s.charAt(i));
            } else {
                newstr.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return newstr.toString();
    }
}