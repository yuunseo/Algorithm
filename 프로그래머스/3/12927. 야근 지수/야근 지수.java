/*
idea: 최소 야근 피로도 반환하기
- N시간동안 일 하고, 남은 일을 제곱한 총합이 야근 피로도
- 1시간에 1만큼 작업할 수 있음
- 즉, work들을 모두 최소화해야지 제곱의 합도 최소가 되는 것!
- works들의 원소들을 우선순위 큐로 해서, 제일 높은게 맨 앞에 오고 하나씩 줄이고 다시 집어 넣기
- n이 끝나면, 원소들을 제곱해서 더하기!
*/
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
      
        // 자료구조 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        for(int work: works){
            pq.add(work);
        }
        
        // 반복 계산
        while(n>0){
            int max = pq.poll();
            if(max<=0) break;
            max--;
            n--;
            pq.add(max);
        }
        
        // 결과 계산 후 반환
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur < 0){
                break;
            }
            result += cur*cur;
        }
        
        return result;
    }
}