/*
BFS 이용하기
1. 주어진 수를 가지고 활용할 수 있는 방법이 + 혹은 -
2. +하는 경우와 -하는 경우를 큐에 삽입 -> 이때

*/
import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        // target을 만들 수 있는 큐 생성
        Deque<int[]> queue = new ArrayDeque<>();
        int len = numbers.length;
        
        int idx = 0;
        // 하나의 수에 대해 처리할 수 있는 2가지 경우 삽입
        queue.offer(new int[] {numbers[idx],1});
        queue.offer(new int[] {-numbers[idx++],1});
                
        while(!queue.isEmpty()){
            // 큐에서 하나씩 꺼내면서 그 다음 처리 반복
            int[] cur = queue.poll();
            int value = cur[0];
            int cnt = cur[1];
            
            if(cnt == len){
                if(value == target){
                    answer++;
                }else{
                    continue; // 다음 순서로 이동
                }
            }else{
                queue.addFirst(new int[] {value+numbers[cnt], cnt+1});
                queue.addFirst(new int[] {value-numbers[cnt], cnt+1});    
            }
        }
        
        return answer;
    }
}