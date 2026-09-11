/*
[아이디어]
1. progressess에 들어있는 작업이 끝날 때까지 속도를 내서 배포를 해야 함.
2. Queue를 사용해서, 현재 가장 먼저 들어온 작업의 완료 일자보다 다음 작업들이 더 일찍 끝났으면 count+1 - O(N)
*/
import java.util.*; 
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        
        // 작업이 완료됐는지 확인하기 위한 자료구조 큐 q
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            int n = (100 - progresses[i]) / speeds[i];
            int m = (100 - progresses[i]) % speeds[i];
            int days = m > 0 ? n+1 : n;
            q.offer(days);
        }
        
        // 모든 작업이 완료될 때까지 반복
        while(!q.isEmpty()){
            int cur = q.poll();
            int next = !q.isEmpty() ? q.peek() : 100;
            int count = 1;
            
            while(cur >= next && !q.isEmpty()){
                q.poll();
                count++;
                if(!q.isEmpty()){
                    next = q.peek();
                }                
            };
            
            list.add(count);
            
        }
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;

    }
}