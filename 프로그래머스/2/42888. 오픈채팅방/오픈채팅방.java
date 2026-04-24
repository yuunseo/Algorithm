/*
1. key: 아이디 value: 닉네임
2. 큐에 차례대로 {아이디,in/out}을 저장 
*/
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String, String> user = new HashMap<>(); // id : nickname 저장을 위한 맵
        Queue<String[]> q = new LinkedList<>(); // 사용자 기록을 위한 큐
        
        for(String str: record){
            String[] str_temp = str.split(" ");
            String type = str_temp[0];
            String id = str_temp[1];
            
            if(type.equals("Leave")){ // Leave의 경우, 사용자 기록에 추가
                q.add(new String[] {id, type});
            }else{
                String nickname = str_temp[2];
                user.put(id, nickname); // Change의 경우, 기존에 저장된 nickname 갱신
                if(type.equals("Enter")){ // Enter의 경우, nickname 및 기록 추가
                    q.add(new String[] {id, type});
                }
            }
        }
        
        // 최종 변경된 닉네임으로 결과 출력
        String[] result = new String[q.size()];
        int idx = 0;
        while(!q.isEmpty()){
            String[] temp = q.poll();
            String id = temp[0];
            String type = temp[1];
            if(type.equals("Leave")){
                result[idx++] = user.get(id)+"님이 나갔습니다.";
            }else{
                result[idx++] = user.get(id)+"님이 들어왔습니다.";
            }
        }
        
        
        return result;
    }
}