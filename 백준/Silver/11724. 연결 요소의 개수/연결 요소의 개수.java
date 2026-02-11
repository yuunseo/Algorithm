/*
그래프의 네트워크 개수 구하기 -> dfs 
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[N+1];
        int[][] map = new int[N+1][N+1];
        for(int i=0; i<M; i++){ // map 초기화
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            map[a][b] = 1;map[b][a] = 1;
            map[a][a] = 1; map[b][b] = 1;
        }
        
        // 한 컴퓨터씩 판별
        int answer = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(map,visited, i,N);
                answer++;
            }
        }
        
        System.out.println(answer);
            
    }
    
    static void dfs(int[][] map, boolean[] visited, int target, int N){
        visited[target] = true;
        
        for(int i=1; i<=N; i++){
            if(target!=i && !visited[i] && map[target][i] == 1){
                dfs(map,visited, i,N);    
            }
            
        }
    }
}