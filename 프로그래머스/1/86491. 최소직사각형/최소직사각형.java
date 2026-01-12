/*
- 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들기
1. 회전이 가능하므로 -> 정렬해서 통일시키기 (가로 혹은 세로)
2. 가로 세로 중 각각 최댓값끼리 곱하여 반환하기

- 시간 복잡고
1. 정렬 : N
2. 최댓값 찾기 : N
즉, N -> 10000 (가능)
*/
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_wid = 0;
        int max_len = 0;
        
        // 1. 정렬
        for(int i=0; i<sizes.length; i++){
            if (sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            // 2. 최댓값 찾기
            if(max_wid < sizes[i][0]){
                max_wid = sizes[i][0];
            }
            if(max_len < sizes[i][1]){
                max_len = sizes[i][1];
            }
            
        }
        
        // 3. 최대 지갑의 크기
        answer = max_wid * max_len ;
        
        return answer;
    }
}