/*
<형변환의 종류>
- 기본형 변수(char x) -> 문자열(s)
String s = String.valueOf(x);
- 정수형 변수(int x) -> 문자열(s)
String s = Integer.toString(x);
- 문자열 변수(String s) -> 문자 배열(c)
char[] c = s.toCharArray();

*/

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = Integer.toString(n);
        for(char c : s.toCharArray())
            answer += Integer.parseInt(String.valueOf(c));

        return answer;
    }
}