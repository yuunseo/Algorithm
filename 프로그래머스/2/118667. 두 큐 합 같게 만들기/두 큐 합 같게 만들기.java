import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        /* queue로 계산 */
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        /* 총합 계산 후, 중간 값 초기화*/
        long q1_total = 0;
        long q2_total = 0;
        for(int item: queue1){
            q1.add(item);
            q1_total += item;
        }
        for(int item: queue2){
            q2.add(item);
            q2_total += item;
        }
        
        if((q1_total+q2_total)%2 != 0) return -1; // 홀수인 경우 불가능 출력
        
        long mid = (q1_total+q2_total)/2;
        
        /* 큰 큐에서 작은 큐로 이동시키기 */
        int count = 0;
        while(count <=  queue1.length * 3){ // 두 큐를 서로 모두 확인하고도 못 찾으면 불가능
            if(q1_total > q2_total){
                int item = q1.poll();
                q2.add(item);
                q1_total -= item;
                q2_total += item;
                count++;
            }else if(q1_total < q2_total){
                int item = q2.poll();
                q1.add(item);
                q2_total -= item;
                q1_total += item;
                count++;
            }else{
                return count;
            }
        }
        
        return answer;
    }
}