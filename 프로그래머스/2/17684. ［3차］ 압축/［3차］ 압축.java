import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        // 사전 초기화
        for(int i=0; i<26; i++){
            dic.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        int idx = 0;
        int dicIdx = 27;
        
        while(idx < msg.length()){
            String w = String.valueOf(msg.charAt(idx));
            int nextIdx = idx + 1;
            
            // 가장 긴 문자열 찾기
            while(nextIdx <= msg.length() && dic.containsKey(msg.substring(idx, nextIdx))){
                w = msg.substring(idx, nextIdx);
                nextIdx++;
            }
            
            // 출력
            answer.add(dic.get(w));
            
            // 사전에 추가
            if(nextIdx <= msg.length()){
                dic.put(msg.substring(idx, nextIdx), dicIdx++);
            }
            
            // 이동
            idx += w.length();
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}