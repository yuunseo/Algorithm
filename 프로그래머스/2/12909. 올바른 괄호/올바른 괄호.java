/*
[아이디어]
1. s에서 한 글자씩 읽어, Stask에 넣는다 -> O(n)
2. 넣기 전, peek해서 짝이 맞으면 pop -> O(1)
3. 모든 글자를 읽었는데 Stack이 남아있으면, 실패!
*/
import java.util.*;

class Solution {
    boolean solution(String s) {
        
        // stack 초기화
        Deque<Character> stack = new ArrayDeque<>();
        
        // 한 글자씩 읽기
        for(char c: s.toCharArray()){
            if(stack.isEmpty() || c=='('){ // stack이 비었거나 여는 괄호면, 삽입
                stack.push(c);
            } // 들어있던 문자와 한 쌍이면, 삭제
            else if(c == ')' && stack.peek() == '('){ 
                stack.pop();
            }
        }
        
        return stack.isEmpty() ? true : false;
       
    }
}