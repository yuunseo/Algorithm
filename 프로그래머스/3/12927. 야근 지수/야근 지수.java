/*
n번 줄여서 최대한 works 내부 값을 작게 만들기
*/
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        while(n>0 && !pq.isEmpty()){
            int max = pq.poll();
            max--; n--;
            
            if(max == 0) continue;
            pq.add(max);
            
        }
        
        if(pq.isEmpty()){
            answer = 0;
        }else{
            while(!pq.isEmpty()){
                answer += Math.pow(pq.poll(),2);
            }
        }
        
        return answer;
    }
}