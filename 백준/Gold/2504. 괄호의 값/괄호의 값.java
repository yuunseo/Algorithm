import java.util.*; 
import java.io.*; 

class Main{ 
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        // 자료구조 초기화
        int answer = 0;
        Stack<Object> stack = new Stack<>();
        
        // 한 문자씩 반복
        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            
            if(cur == '(' || cur == '['){
                stack.push(cur);
            }
            else{
                int sum = 0;
                boolean matched = false;
                
                while(!stack.isEmpty()){
                    Object top = stack.pop();
                    
                    // 숫자라면 내부 합에 더하기
                    if(top instanceof Integer){
                        sum += (int) top;
                    }
                    // 괄호라면
                    else{
                        if(cur == ')' && (char)top == '('){
                            stack.push(sum==0 ? 2 : sum*2);
                            matched=true;
                            break;
                        }else if(cur == ']' && (char)top == '['){
                            stack.push(sum==0 ? 3 : sum*3);
                            matched=true;
                            break;
                        }else{
                            System.out.println(0);
                            return;
                        }
                    }
                }
                
                if(!matched){
                    System.out.println(0);
                    return;
                }
            }
        }
            
        while(!stack.isEmpty()){
            Object top = stack.pop();
            if(top instanceof Character){
                System.out.println(0);
                return;
            }
            answer += (int) top;
        }
        System.out.println(answer);
    }
}