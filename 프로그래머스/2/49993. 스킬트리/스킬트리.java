import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // skill의 우선순위 저장
        Map<Character, Integer> skill_ranking = new HashMap<>();
        for(int i=0; i<skill.length(); i++){
            skill_ranking.put(skill.charAt(i), i+1);    
        }
        
        
        for(String sk: skill_trees){
            int cur = -1;
            int prev = -1;
            boolean flag = true;
            int ranking = 1;
            for(char c: sk.toCharArray()){
                
                if(skill_ranking.containsKey(c)){
                    cur = skill_ranking.get(c);
                    if(cur != ranking || cur < prev){
                        flag = false;
                        break;
                    }else{
                        ranking++;
                        prev = cur;
                    }
                }else{
                    continue;
                }
                
            }
            if(flag)answer ++; 
        }
        
        return answer ;
    }
}