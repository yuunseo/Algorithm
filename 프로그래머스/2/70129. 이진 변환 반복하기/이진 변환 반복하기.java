import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 자료구조 초기화
        int stage = 0;
        int total_zero_count = 0;
        
        while(!s.equals("1")){
            // 1. s에서 0 개수 세고 제거하기
            int zero_count = 0;
            for(char c: s.toCharArray()){
                if(c=='0'){
                    zero_count++;
                }
            }

            // 2. 기존 길이에서 zero count 뺸 길이 2진수로 변환
            total_zero_count += zero_count;
            s = Integer.toBinaryString(s.length() - zero_count);
            stage++; 
        }
        
        return new int[] {stage, total_zero_count};
    }
    
   
}