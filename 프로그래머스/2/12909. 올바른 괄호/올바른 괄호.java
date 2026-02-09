/*
올바른 괄호인지 판별하기-> stack
( 여는 괄호는 push
) 닫는 괄호는 peek해서 열린 괄호면 pop하기
괄호가 남아있으면 false
*/
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
                continue;
            }else{
                return false;
            }
        }
    
        return !stack.isEmpty() ? false : true;
    }
}