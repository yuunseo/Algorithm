import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++){
            int curEnemy = enemy[i];
            
            // 우선 현재 적과 싸우고, pq에 삽입 (이후 무적권에 이해 삭제 예정)
            n -= curEnemy;
            pq.add(curEnemy);
            
            if(n < 0){ // 병사가 모자라면, 무적권 써야함!
                if(k > 0 && !pq.isEmpty()){
                    n += pq.poll();
                    k--;
                }else{ // 무적권이 모자라면, 종료
                    break;
                }
            }
            
            answer ++; // 성공했으니, 라운드 추가
        }
        
        return answer;
    }
}