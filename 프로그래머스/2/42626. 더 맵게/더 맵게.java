import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 최종 결과물
        int count = 0;
        
        // 우선순위 힙(우선순위가 작은 수 부터 반환=최솟값부터)
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int n: scoville){
            pq.add(n);
        }
        
        while(pq.peek()<K){
            // k 미만인 값들 뿐의 경우, -1 반환
            if(pq.size()<2){
                return -1;
            }
            
            // item 2개를 꺼내서 새로운 값으로 섞은 후, 반복
            int first = pq.poll();
            int second = pq.poll();
            int new_one = first + second*2;
            
            pq.add(new_one);
            count++;
            
        }
        
        return count;
    }
}