/*
Q. n개의 자연수들을 이용해서 타겟 넘버를 만드세요. 만들 수 있는 모든 경우의 수를 반환하기
A. 모든 경우의 수를 구하는 알고리즘은 보통 DFS로 가지를 뻗어나가는 형태의 그래프 탐색을 이용.
*/

import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
         
        dfs(numbers, target, 0, numbers[0]); // 양수로 시작
        dfs(numbers, target, 0, -numbers[0]); // 음수로 시작
        
        return answer;
        
    }
    
    private void dfs(int[] numbers, int target, int idx, int total){
        // 종료 조건
        if(idx+1 == numbers.length){
            if(total == target) answer += 1;
            return;
        }
        
        // 재귀
        dfs(numbers, target, idx+1, total + numbers[idx+1]);
        dfs(numbers, target, idx+1, total - numbers[idx+1]);
        
    }
    
}