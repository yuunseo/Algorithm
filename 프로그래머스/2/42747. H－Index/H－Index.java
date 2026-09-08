/*
[아이디어]
1. citations를 오름차순 정렬한다 - O(nlogn)
2. h번 이상 인용된 개수: citations.length - index
3. h번 인용된 논문: citations[index] 
4. h번 이상 인용된 논문 개수가 h번 이상인 경우, 찾으면 반환하기 - O(n)
*/
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations); // 0 1 3 5 6 (5)
        
        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;
            
            if(citations[i] >= h) return h;
        }
        
        return 0;

    }
}