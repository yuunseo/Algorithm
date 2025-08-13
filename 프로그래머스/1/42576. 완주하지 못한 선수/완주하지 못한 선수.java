/*
- participant 참여자 completion 완주자
- completion에 없는 참여자를 선택하면 됨. 동명이인이 있을 수 있음 주의 !!!!
- 그럼 동명이인이더라도 한 명당 하나의 key를 갖도록 해주자

*/
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> partic = new HashMap<>();

        // 참가자 카운트
        for (String name : participant) {
            partic.put(name, partic.getOrDefault(name, 0) + 1);
        }

        // 완주한 사람 차감
        for (String name : completion) {
            partic.put(name, partic.getOrDefault(name, 0) - 1);
        }

        // 값이 1(또는 >0)인 사람이 미완주자
        for (Map.Entry<String, Integer> e : partic.entrySet()) {
            if (e.getValue() > 0) return e.getKey();
        }
        return ""; // 문제 조건상 도달하지 않음
    }
}
