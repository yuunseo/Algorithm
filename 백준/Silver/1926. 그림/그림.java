import java.util.*;
import java.io.*;

class Main{
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<int[]> q;
    static boolean[][] visited;
    static int[][] map;
    static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 0,0 부터 모든 칸을 하나씩 바꾸기
        int count = 0;
        int maxSize = 0;
        q = new LinkedList<>();
        visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] || map[i][j] == 0) continue;
                q.add(new int[] {i,j});
                visited[i][j] = true;
                maxSize = Math.max(maxSize,bfs());
                count++;
            }
        }
        
        System.out.println(count);
        System.out.println(maxSize);
       
    }
    
    static int bfs(){
        int size = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d=0;d<4;d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(nx<0||ny<0||ny>=N||nx>=M) continue;
                
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    q.add(new int[] {ny,nx});
                    visited[ny][nx] = true;
                    size++;
                }
            }
        }
        
        return size;
    }
}