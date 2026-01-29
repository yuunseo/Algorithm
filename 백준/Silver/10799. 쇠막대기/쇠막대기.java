import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int idx = 0;
        while(idx<str.length()){
            char cur = str.charAt(idx++);
            if(cur == '('){
                stack.push(cur);
            }else if(cur == ')'){
                char pre = str.charAt(idx-2);
                if(pre=='('){ // 레이저인 경우, stack에 있는 막대만큼 개수 증가
                   stack.pop(); // 레이저의 시작 괄호 제거 
                   answer += stack.size();
                }else if(pre==')'){ // 막대의 끝인 경우, +1개수 증가
                    stack.pop(); // 막대 하나 제거
                    answer += 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}