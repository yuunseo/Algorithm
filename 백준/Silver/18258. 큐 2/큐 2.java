/*
Queue 구현하기
- 큐란, FIFO의 특성을 가진 자료구조
- front : 가장 앞 원소(삭제 위치)
- rear  : 다음 삽입 위치
*/

import java.util.*;
import java.io.*;

class Main{
    
    static int[] queue;
    static int front = 0;
    static int rear = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        // 큐 구현하기
        queue = new int[N];
        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            
            if(str.startsWith("push")){
                int num = Integer.parseInt(str.split(" ")[1]);
                queue[rear] = num;
                rear++;
            }else if(str.equals("pop")){
                if(front == rear) sb.append(-1).append("\n");
                else sb.append(queue[front++]).append("\n");
            }else if(str.equals("size")){
                sb.append(rear-front).append("\n");
            }else if(str.equals("empty")){
                if(front==rear) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(str.equals("front")){
                if(front==rear) sb.append(-1).append("\n");
                else sb.append(queue[front]).append("\n");
            }else{
                if(front==rear) sb.append(-1).append("\n");
                else sb.append(queue[rear-1]).append("\n");
            }
            
        }
        System.out.print(sb.toString());
    }

}