/*
스택 수열
- LIFO, top pointer
- push: 오름차순으로 삽입
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        boolean result = true; 
        int num = 1;
        StringBuilder sb = new StringBuilder();
        
        
        Stack<Integer> stack = new Stack<>(); // 스택 자료구조
        int[] targets = new int[n]; // target 배열
        for(int i=0; i<n; i++){
            targets[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        
        while(idx < n){
            if(stack.isEmpty()){ // 초기화
                stack.push(num++);
                sb.append("+\n");
            }
            
            int last = stack.peek();
            if(last > targets[idx]){
                result = false;
                break;
            }else if(last == targets[idx]){
                stack.pop();
                sb.append("-\n");
                idx++;
            }else if(last < targets[idx]){
                stack.push(num++);
                sb.append("+\n");
            }
        }
        
        if(result){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
        
        
    }
}