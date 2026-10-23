
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // times 정렬
        Arrays.sort(times);
        
        // 최소, 최대 시간 초기화
        long min = 1;
        long max = (long) times[times.length-1] * n;
        
        // 이분탐색
        while(min <= max){
            long mid = (min+max)/2;
            
            // mid 시간동안 몇 명을 심사할 수 있을까?
            long people = 0;
            for(long time: times){
                people += mid / time;
            }
            
            // n명 모두 할 수 있으면 성공
            // 더 적은 시간으로 할 수 있는지 확인하기
            if(people >= n){
                answer = mid;
                max = mid-1;
            }

            // n명 모두 심사하기에 부족하다면
            // 더 많은 시간으로 확인하기
            else{
                min = mid+1;
            }
        }
        
        return answer;
        
        
    }
}