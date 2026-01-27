/*
프린터의 작업순서 FIFO
- 맨앞 문서의 중요도 추출 -> 뒤 나머지 중요도보다 작으면 poll & add
- 중요도의 순서대로 정렬되어야 하고, 중요도의 인덱스도 함께 저장되어야 함!
*/

import java.util.*; import java.io.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    
    static void findPaper(int N, int M, String str){
        if(N==1){
            sb.append(1).append("\n");
            return;
        }
        
        StringTokenizer st = new StringTokenizer(str);
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> priorities = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            priorities.add(n);
            queue.add(new int[]{n, i});

        }
        
        int cnt=0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int priority = cur[0];
            int index = cur[1];

            if(priorities.peek() == priority){
                priorities.poll();
                cnt++;
                
                if(index == M){
                    sb.append(cnt).append("\n");
                    break;
                }
            }else{
                queue.add(cur);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 순서
            String str = br.readLine();
            
            findPaper(N,M,str);// 순서 찾기
        }
        
        System.out.println(sb);
    }
    
}