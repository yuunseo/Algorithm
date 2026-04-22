/*
숫자 포함 정렬하기
- 대소문자 구분 없이
- number 구간 오름차순 정렬하기 (맨 앞 0은 구분없이)
- 원래 순서 기억하고 있다가, 우선순위 똑같으면 원래 순서대로 
아이디어
- 0 인덱스부터 시작해서 알파벳 구간 구하기 HEAD
- 연속 숫자 구간 구하기 NUMBER
- 나머지는 TAIL
*/
import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {

                String a_head = getHead(a);
                String b_head = getHead(b);

                int headCompare = a_head.compareTo(b_head);
                if (headCompare != 0) return headCompare;

                int a_number = getNumber(a);
                int b_number = getNumber(b);

                return a_number - b_number;
            }
        });

        return files;
    }

    static String getHead(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) break;
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    static int getNumber(String str) {
        StringBuilder sb = new StringBuilder();

        boolean numberStarted = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                numberStarted = true;
                sb.append(c);
            } else if (numberStarted) {
                break;
            }
        }

        return Integer.parseInt(sb.toString());
    }
}