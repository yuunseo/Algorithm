/*
k번째 값을 추출해야 하므로, k-1번 맨 앞의 값을 뒤로 이동시키기
그 다음 맨 첫 번째 값이 k번째 값이 되므로 추출
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> queue = new LinkedList();
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()){
            for(int i=0; i<K-1; i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if(!queue.isEmpty()) sb.append(", ");
        }
        
        sb.append(">");
        System.out.println(sb);
        
    }
}