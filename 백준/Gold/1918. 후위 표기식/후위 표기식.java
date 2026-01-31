import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> op = new HashMap<>();
        op.put('+',1);op.put('-',1);
        op.put('*',2);op.put('/',2);
        
        
        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            
            // 연산자라면 push
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/'){
                while(!stack.isEmpty() && stack.peek() != '(' &&
                      op.get(stack.peek()) >= op.get(cur)){
                    sb.append(stack.pop());
                }
                stack.push(cur);
            }
            // 여는 괄호라면, push
            else if(cur == '(') {
                stack.push(cur);
            }
            // 닫는 괄호라면, 여는 괄호 나올 때까지 연산자 out
            else if(cur == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            // 피연산자라면, 바로 출력
            else{
                sb.append(cur);
            }
        }
        
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c != '('){
                sb.append(c);
            }
        }
        
        System.out.println(sb.toString());
        
    }
}