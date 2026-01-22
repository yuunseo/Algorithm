/*
stack (LIFO)
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int top = 0;
        StringBuilder sb = new StringBuilder();
        int[] stack = new int[N];
        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            
            if(str.startsWith("push")){
                if(top<N){
                    stack[top++] = Integer.parseInt(str.split(" ")[1]);
                }
            }else if(str.equals("pop")){
                if(top==0) sb.append("-1").append("\n");
                else sb.append(stack[--top]).append("\n");
            }else if(str.equals("size")){
                sb.append(top).append("\n");
            }else if(str.equals("empty")){
                if(top==0) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }else if(str.equals("top")){
                if(top==0) sb.append("-1").append("\n");
                else sb.append(stack[top-1]).append("\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}