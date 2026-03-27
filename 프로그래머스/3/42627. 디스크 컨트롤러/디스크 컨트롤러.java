import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        
        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] != b[1]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        
        int current = 0;
        int idx = 0;
        
        while(idx < n || !pq.isEmpty()){
            
            // 현재 시간까지 들어온 작업 추가
            while(idx < n && jobs[idx][0] <= current){
                pq.add(jobs[idx]);
                idx++;
            }
            
            // 작업 없으면 시간 점프
            if(pq.isEmpty()){
                current = jobs[idx][0];
                continue;
            }
            
            int[] cur = pq.poll();
            int start = cur[0];
            int time = cur[1];
            
            current += time;
            answer += (current - start);
        }
        
        return answer / n;
    }
}