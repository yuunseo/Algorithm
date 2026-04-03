import java.io.*;
import java.util.*;

public class Main {
    static class Block{
        int y,x,len;
        boolean used;
        
        Block(int y, int x, int len, boolean used){
            this.y=y;
            this.x=x;
            this.len=len;
            this.used=used;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N+1][M+1];
        boolean[][][] visited = new boolean[N+1][M+1][2];
        
        // 전체 배열
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j+1] = str.charAt(j)-'0';
            }
        }
        
        // 이동 배열
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        // BFS
        Queue<Block> q = new LinkedList<>();
        q.add(new Block(1,1,1, false));
        visited[1][1][0] = true;
        
        while(!q.isEmpty()){
            Block cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int len = cur.len;
            boolean used = cur.used; // 벽 부쉈는가?
            
            if(y==N && x==M){
                System.out.println(len); return;
            }
            
            for(int d=0; d<4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if(ny<=0 || nx<=0 || nx>M || ny>N) continue;
                if(map[ny][nx] == 0 && !visited[ny][nx][used? 1 : 0]){
                    // 벽이 아니라면 그냥 이동
                    q.add(new Block(ny, nx, len+1, used));
                    visited[ny][nx][used? 1 : 0] = true;
                }else{
                    // 벽이라면 부수고 이동할 수 있음
                    if(used || visited[ny][nx][1]) continue;
                    q.add(new Block(ny, nx, len+1, true));
                    visited[ny][nx][1] = true;
                }
            }
        }

        System.out.println(-1);
    }
}