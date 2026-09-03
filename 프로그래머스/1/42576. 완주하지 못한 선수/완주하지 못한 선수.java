import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // participants를 map 형태로 변경하기
        Map<String, Integer> map = new HashMap<>();
        for(String name: participant){
            map.put(name, map.getOrDefault(name,0)+1);
        }
        
        // completion에 존재하는 이름이면 map에서 제거하기
        for(String name: completion){
            if(map.get(name) > 0){
                map.put(name, map.get(name)-1);
            }
        }
        
        // 완주하지 못한 선수 찾기
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 1) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}
