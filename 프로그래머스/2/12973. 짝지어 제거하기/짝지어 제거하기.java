import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            // 1. 이전에 들어있는 문자 확인하기
            if(stack.isEmpty()){ // 1-1. 비어있으면, push
                stack.push(c);
            }else{ // 1-2. 비어있지 않으면, peek 
                if(stack.peek() == c){ // 2-1. 현재 문자와 동일하면, 꺼내기
                    stack.pop();
                    continue;
                }else{ // 2-2. 현대 문자와 다르면, 넣기
                    stack.push(c);
                }
            }
        }

        
        return stack.isEmpty() ? 1 : 0;
    }
}