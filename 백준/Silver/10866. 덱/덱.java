/*
덱 = 원형 큐
- 앞 혹은 위에서 삽입/삭제가 가능한 큐
*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // deque 자료구조
        Deque<Integer> deque = new ArrayDeque<>();
        
        // 명령어
        for(int i=0; i<N; i++){
            String command = br.readLine();
            
            if(command.startsWith("push_front")){
                int num = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(num);
            }else if(command.startsWith("push_back")){
                int num = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(num);
            }else if(command.startsWith("pop_back")){
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            }else if(command.startsWith("pop_front")){
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            }else if(command.equals("size")){
                sb.append(deque.size()).append("\n");
            }else if(command.equals("empty")){
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }else if(command.equals("front")){
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            }else if(command.equals("back")){
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }
        
        System.out.println(sb);
    
    }
}