/*
<아이디어>
1. s에서 i=0부터 문자를 하나씩 읽어온 후, 새로운 배열에 추가한다.
2. 새로운 배열은 길이가 유동적이어야 하므로, ArrayList 사용하기
3. 새로운 배열에 내가 지금 넣을 문자가 존재한다면, 해당 배열의 길이 - 넣을 문자와 동일할 문자의 인덱스 를 반환
4. 이때, 동일한 문자가 여러 개라면 가장 뒤에서 부터 존재하는 글자 찾아서 반환 -> lastIndexOf
5. 최종 반환 자료형은 int[]
*/

import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 결과물 반환 배열 생성
        int[] answer = new int[s.length()];
        
        // 한 글자씩 비교할 배열 생성
        ArrayList<Character> char_list = new ArrayList<Character> ();
        
        // for문을 활용해서 한 글자씩 불러오기
        char c = '.';
        int j = -1;
        for(int i=0; i<s.length(); i++){
            // 한 글자씩 불러오기
            c = s.charAt(i);
            
            // 동적 배열에 존재 여부 판단하기
            j = char_list.lastIndexOf(c); // c와 동일한 문자를 가지고 있다면, 뒤에서 부터 인덱스 출력, 없다면 -1
            if(j == -1)
                answer[i] = j;
            else
                answer[i] = char_list.size() - j;
            
            char_list.add(c);
        }
    
        
        return answer;
    }
}