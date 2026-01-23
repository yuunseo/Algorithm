/*
괄호의 짝이 맞지 않으면 VPS가 아님!
stack의 특징 활용
( 좌측 괄호가 추가되면, ) 우측 괄호와 짝을 이룸
따라서 stack이 빈 채로 끝나면 YES 나머지가 있으면 NO
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int T = Integer.parseInt(br.readLine());
        char[] stack;
        int top;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T; i++){
            String str = br.readLine();
            stack = new char[50];
            top = 0;
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(top == 50) sb.append("NO").append("\n");
                
                if(c == '('){
                    stack[top++] = c;
                }
                else if(c == ')'){
                    if(top==0){
                        stack[top++] = c;
                    }else{
                        if(stack[top-1] == '('){
                            top--;
                        }else{
                            stack[top++] = c;
                        }
                    }
                }
            }
            if(top == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        
        System.out.println(sb.toString());
    }
}