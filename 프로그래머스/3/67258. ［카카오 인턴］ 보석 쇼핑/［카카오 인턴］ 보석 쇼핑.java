import java.util.*;

class Solution {
    
    
    
    public int[] solution(String[] gems) {
        
        // 종류 개수 구하기
        Set<String> game_set = new HashSet<>();
        for(String str: gems){
            game_set.add(str);
        }
        int type = game_set.size();
        
        // games의 index 0번부터 type 개수 0될 때까지 다음 인덱스로 이동 -> 정답 구간과 비교해서 갱신
        int start=0;
        Map<String, Integer> map = new HashMap<>();
        int[] result = new int[] {0,gems.length};
        
        for(int end=0; end<gems.length; end++){
            
            // end 확장
            map.put(gems[end], map.getOrDefault(gems[end],0)+1);
            
            // 모든 종류 포함 시, start 감소
            while(map.size() == type){
                // start부터 다시 하나씩 제거
                map.put(gems[start], map.get(gems[start])-1);
                if(map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }
                
                start ++;
                
                if(result[1] - result[0] > end-start){
                result[0] = start;
                result[1] = end;
                }
            }
            
        }
        
        
        return new int[] {result[0], result[1]+1};
    }
}