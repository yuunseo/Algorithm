/*
1. banned_id를 하나식 선택
2. i번째 id로 걸러지는 user_id를 추가 -> Map
3. 
*/
import java.util.*;

class Solution {
    
    // 결과 자료구조
    static Set<Set<String>> result = new HashSet<>();
    static List<List<String>> arr = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        // 후보 자료구조 만들기
        for(String id: banned_id){
            String new_id = id.replace("*",".");
            
            List<String> ids = new ArrayList<>();
            for(String user: user_id){
                if(user.matches(new_id)){
                    ids.add(user);
                }
            }
            arr.add(ids);
        }
        
        // 후보 조합 만들기
        dfs(0, new HashSet<>());
        
        return result.size();
    }
    
    static void dfs(int idx, Set<String> selected){
        // 모든 banned_id를 다 매칭했으면
        if (idx == arr.size()) {
            result.add(new HashSet<>(selected)); // 중복 방지
            return;
        }
        
        for (String user : arr.get(idx)) {
            // 이미 선택된 유저는 제외
            if (!selected.contains(user)) {
                selected.add(user);
                dfs(idx + 1, selected);
                selected.remove(user); // 백트래킹
            }
        }
        
    }
    
}