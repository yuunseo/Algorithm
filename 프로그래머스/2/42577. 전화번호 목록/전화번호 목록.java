/*
output
- 한 문자열이 다른 문자의 시작에 포함된다면 false
idea
- 다른 문자열에 포함되는가? 
- 포함된다면 시작 인덱스가 0인가?
- 모두 아니라면, 다음 문자열로 pass
algorithm
- 완전탐색: O(n^2) = 10^12 (초과)
- 정렬 후 탐색: O(NlogN) = 10^6* (흠)
*/
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 오름차순 정렬
        Arrays.sort(phone_book);
        
        // 앞뒤 아이템 비교
        for(int i=0; i<phone_book.length-1; i++){
            String prev = phone_book[i];
            String next = phone_book[i+1];
            
            if(next.startsWith(prev)){
                return false;
            }
        }
        
        return answer;
    }
}