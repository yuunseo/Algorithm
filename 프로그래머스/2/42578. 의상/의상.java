/*
[아이디어]
1. 의상 종류를 key로, 의상의 개수를 value로 저장한다 - O(n)
2. 경우의 수 구하기: 의상은 같은 종류를 중복선택 할 수 없으므로 독립적임 (각각의 개수 곱해서 -1) - O(n)
*/
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. HashMap 초기화
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth: clothes){
            String type = cloth[1];
            map.put(type, map.getOrDefault(type,0)+1);            
        }
        
        // 2. 경우의 수 계산하기 (안 입는 경우 +1 포함)
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1); // (해당 종류의 개수 + 안 입는 경우)
        }
        
        // 3. 아무것도 안 입는 경우 1가지를 빼고 반환
        return answer - 1;
        
    }
}