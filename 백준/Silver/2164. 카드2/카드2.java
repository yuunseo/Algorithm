/*
while(카드 개수가 1장보다 많은 경우 반복)
- 맨 위 카드 버리기 remove
- 맨 위 카드 맨 뒤로 옮기기
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        
        
        while(queue.size()>1){
            queue.poll();
            queue.add(queue.poll());
        }
        
        System.out.println(queue.peek());
        
    }
}