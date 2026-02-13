/*
최대한 많이 뽑는데, 뽑았을 때 모인 숫자의 집합이 같아야함
n에서 출발한 dfs가 결국 자기 자신으로 돌아오는지 찾기 -> 돌아오면 추가 아니면 패스
*/

import java.util.*;
import java.io.*;

class Main{
    
    static int total = 0;
    static boolean[] answer;
    static int[] nums;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 초기화
        int N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        for(int i=0; i<N; i++){
            nums[i+1] = Integer.parseInt(br.readLine());
        }
        answer = new boolean[N+1];
        
        // 각 수에서 dfs
        for(int i=1; i<=N; i++){
            boolean[] visited = new boolean[N+1];
            dfs(visited, i, i);
        }
        
        // true인 개수 출력
        sb.append(total).append("\n");
        for(int i=1; i<=N; i++){
            if(answer[i]) sb.append(i).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    static void dfs(boolean[] visited, int start, int cur){
        visited[cur] = true;
        int next = nums[cur];
        
        if(!visited[next]){
            dfs(visited, start, next);
        }else if(next == start){ // 시작점과 현재, 즉 사이클이라면 true
            answer[start] = true;
            total++;
        }
    }
}