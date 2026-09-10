/*
[아이디어]
1. 각각의 전화번호를 오름차순 정렬 - ONlogN)
2.startsWith()로 시작하는 게 있는지 확인하기 - O(N)
4. 있으면 false 반환, 없으면 true - O(1)
*/
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
       
        Arrays.sort(phone_book, (a,b) -> {
            return a.compareTo(b);
        });
        
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}