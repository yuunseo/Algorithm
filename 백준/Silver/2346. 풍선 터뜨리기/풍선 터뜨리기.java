/*
원형큐(덱)
1~N개의 풍선: -N~N의 수가 적혀있음
1번 풍선 peek ->0으로 바꾸고 -> 값만큼 이동 -> 반복

그런데 각 값의 인덱스를 기억해야 하므로, 배열이 필요함! linkedList? ArrayDeque?
- +N할 떄는 %N
- -N할 때는 + N 
*/

import java.util.*;
import java.io.*;

class Main{
    
    static class Balloon{
        int idx;
        int move;
        
        Balloon(int idx, int move){
            this.idx = idx;
            this.move = move;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        
        // N번 반복 시작 
        StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()){
                Balloon cur = deque.pollFirst();
                sb.append(cur.idx).append(" ");
                
                int move = cur.move;
                
                if(deque.isEmpty()) break;
                
                if(move > 0){
                    for(int i=0; i<move-1; i++){
                        deque.addLast(deque.pollFirst());
                    }
                }else{
                    for(int i=0; i<-move; i++){
                        deque.addFirst(deque.pollLast());
                    }
                }
            }
        
        System.out.println(sb);
        
        
    }
}