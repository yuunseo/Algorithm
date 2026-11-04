import java.util.*;

class Solution {
    boolean solution(String s) {
        // 첫 종료 조건
        if(s.charAt(0) == ')') return false;
        
        // 자료구조 초기화
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek() == ')') return false;
                else stack.pop();
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
       
    }
}