import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        // 문자열 -> 시간으로 치환
        int[][] times = new int[book_time.length][2]; // 시작시간, 종료시간
        for(int i=0; i<book_time.length; i++){
            times[i][0] = parseTime(book_time[i][0]);
            times[i][1] = parseTime(book_time[i][1]);
        }
        
        // 정렬
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        // 우선순위 큐 : 사용 중인 방 퇴실 시간 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] time: times){
            // 방 비었으면, 추가
           if (pq.isEmpty()) { 
                pq.add(time[1]);
                continue;
            }
            
            // 이전 방 청소 끝난 이후, 예약 가능
            if(pq.peek()+10 <= time[0]){
                pq.poll(); // 이전 방 지우고, 현재 방으로 업데이트 (정렬했으니까 다시 볼 필요없음))
            }
            
            pq.add(time[1]);
        }
        
        return pq.size();
        
        
    }
    
    private int parseTime(String str_time){
        String[] time = str_time.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}