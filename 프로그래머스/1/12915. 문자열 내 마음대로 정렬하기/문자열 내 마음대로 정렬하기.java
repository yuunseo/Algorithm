/*
[아이디어]
m = 문자열 개수
k = 문자열 최대 길이

1. Arrays.sort()를 활용해 문자열을 정렬한다.
   - 약 O(m log m)번 비교

2. Comparator를 통해 정렬 기준을 지정한다.
   - n번째 문자 비교 charAt(n): O(1)

3. n번째 문자가 동일하다면 compareTo()로
   문자열 전체를 사전순 비교한다.
   - 최악의 경우 O(k)

최종 시간복잡도
= O(m log m) × O(k)
= O(k × m log m)
*/
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (a, b) -> {
            
            // a와 b의 n번째 알파벳이 동일하다면, a와 b 자체 비교
            if(a.charAt(n) == b.charAt(n)){
                return a.compareTo(b);
            }
            
            return a.charAt(n) - b.charAt(n); // 음수면 a가 앞, 양수면 b가 앞
        });
        
        return strings;
     
    }
}