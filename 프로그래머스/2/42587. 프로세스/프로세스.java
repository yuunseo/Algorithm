/*
1. priorities의 인덱스 location이 몇 번째로 출력되는지 출력하기
2. priorities의 인덱스와 우선순위를 함께 묶어서 큐에 담기
3. (0,2) (1,1) (2,3) (3,2) 
4. 현재 판단하는 우선순위보다 큰 우선순위가 있는지 알려면 최대 값을 기억하고 있어야됨 -> 맨 처음에는 기억하면 되는데 그 다음 순서부터는 어쩌지? -> 우선 하나 선택해서 모든 값과 비교하기 (최댓값 저장X)
*/
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 큐 초기화
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            queue.add(new int[] {i,priorities[i]});
        }
        
        // 하나씩 비교
        int seq = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            // 나보다 큰 값 있는지 확인
            boolean moreBigger = false;
            for(int[] next: queue){
                if(next[1] > cur[1]){
                    moreBigger = true;
                    break;
                }
            }
            
            if(moreBigger){
                queue.add(cur);
            }else{
                // 나보다 큰 값 없으면 출력
               if(cur[0] == location){
                   return seq;
               }else{
                   seq++;
                   continue;
               }
            }
        }
        
        return seq;
        
    }
}