/*
1. 0인 칸들 중 3개 고르기
2. 3개를 1로 바꾼 후, 2 확산
3. 남은 0의 개수 세서 answer에 갱신 (answer은 max로 갱신됨)
4. 반복
*/
import java.util.*;
import java.io.*;

class Main{
    
    static int[][] arr;
    static int answer;
    static int N,M;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 0인 칸들 중 3개를 고르는 모든 조합 반복하기
        dfs(0);
        System.out.println(answer);
        
    }
    
    static void dfs(int depth){
        if(depth == 3){
            // 바이러스 확산
            int result = bfs();
            answer = Math.max(answer, result);
            return;
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(depth+1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    
    static int bfs(){
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            copy[i] = arr[i].clone();
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j] == 2){
                    q.add(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d=0;d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
                
                if(!visited[ny][nx] && copy[ny][nx] == 0){
                    copy[ny][nx] = 2;
                    q.add(new int[] {ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
        
        // 안전영역 개수 반환하기
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j] == 0) count++;
            }
        }
        
        return count;
    }
}