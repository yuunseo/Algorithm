/*
[아이디어]
1. split()을 통해 각 단어를 분리시킨다. - O(n)
2. 각 단어를 모두 소문자로 바꾸고,index를 %2==0 짝수인 것만 대문자로 바꾼다. - O(n)
3. 각 단어를 더해서 반환한다. - O(n)
---> 공백이 여러 개 일 수도 있음
1. s를 하나씩 꺼내서 처리한다. - O(n)
2. 공백을 만나면 공백 그대로 추가하고, 초기화한다.
*/
import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 정답
        StringBuilder sb = new StringBuilder();
        
       // 1. 한 글자씩 추출해서 소/대문자로 바꾸기
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            
            // 공백이라면, 공백만 추가
            if(cur == ' '){
                sb.append(' ');
                idx = 0;
                continue;
            }
            
            // idx가 짝수라면, 대문자
            // 아니라면, 소문자
            if(idx % 2 == 0){
                sb.append(Character.toUpperCase(cur));
                idx+=1;
            }else{
                sb.append(Character.toLowerCase(cur));
                idx+=1;
            }
        }
        
        // 정답 반환
        return sb.toString();
        
    }
}