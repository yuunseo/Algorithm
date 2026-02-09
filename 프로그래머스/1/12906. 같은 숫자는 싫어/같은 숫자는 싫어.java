/*
연속 수 제거 및 순서 유지 -> set 불가능
stack에 하나씩 넣으면서 peek과 동일하면 pass, 다르면 push
다 넣었으면, 꺼내서 처음부터 넣기

*/
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int num : arr){
            if(stack.isEmpty()){
                stack.push(num);
            }else{
                int pre = stack.peek();
                if(pre == num){
                    continue;
                }else{
                    stack.push(num);
                }
            }
        }
        
        int[] result = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            result[i] = stack.pop();
        }
        
        return result;
    }
}