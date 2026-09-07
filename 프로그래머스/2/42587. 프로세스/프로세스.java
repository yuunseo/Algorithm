/*
[아이디어]
1. Queue를 초기화한다 - O(1)
2. Queue에 프로세스를 하나씩 넣는다. - O(1)
3. 하나씩 넣을 때, 최댓값을 갱신해서 기록해둔다. - O(1) --> 2/3번 O(n)
4. peek() 해서 최댓값인지 확인하고 아니면, 다시 뒤로 간다. 근데 이때 그럼 새로운 최댓값을 모른다!! 그러니 최댓값 저장을 위해 하나의 자료구조를 둔다. PriorityQueue
*/
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
     
        // queue 초기화: O(1)
        // {value, index}
        Queue<int[]> q = new ArrayDeque<>();
        
        // 우선순위 저장을 위한 queue 초기화: O(1)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // queue에 넣으면서, 우선순위도 함께 기록
        // queue에 n개 삽입: O(n)
        // priority queue에 n개 삽입: O(n)
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[] {priorities[i], i});
            pq.offer(priorities[i]);
        }
        
        // queue 꺼내서 확인하기: O(n)
        int seq = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            // 젤 높은 우선순위가 아니면, 뒤로 이동
            if(cur[0] != pq.peek()){
                q.offer(cur);
            } // 젤 높은 우선순위면, 제거
            else{
                if(cur[1] == location){
                    return seq;
                }else{
                    pq.poll();
                    seq+=1;
                }
                
            }
        }
        
        return -1;
        
    }
}