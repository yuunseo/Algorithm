import java.util.*;

class Solution {
    static int result = 0; // 출력할 경우의 수
    
    public int solution(int[] numbers, int target) {
         
        dfs(numbers, 1, numbers[0], target); // (배열, 시작 인덱스, 총합)
        dfs(numbers, 1, (-1)*numbers[0], target);
        
        return result;
        
    }
    
    static void dfs(int[] numbers, int idx, int total, int target){
        // 종료 조건
        if(idx == numbers.length){ 
            if(total == target) result ++;
            return;
        }
        
        // 재귀 호출
        dfs(numbers, idx+1, total + numbers[idx], target);
        dfs(numbers, idx+1, total - numbers[idx], target);
    }
}