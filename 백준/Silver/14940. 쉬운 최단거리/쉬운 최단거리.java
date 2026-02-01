import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // map 그리기 & 도착지점 좌표 파악
        int[][] map = new int[n][m];
        int[] des = new int[2]; // x,y 좌표
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 2){
                    des[0] = j; des[1] = i;
                }
            }
        }
        
        // 방문 배열
        boolean[][] visited = new boolean[n][m];
        
        // 상하좌우 이동 배열
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        
        // 결과 배열 (거리)
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(result[i], -1);
        }
        
        // BFS 자료구조 초기화
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {des[0], des[1]});
        result[des[1]][des[0]] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx<0 || m<=nx || ny<0 || n<=ny) continue; // 범위를 초과하면 pass
                if(map[ny][nx] != 1) continue; // 벽이라면 pass
                if(result[ny][nx] != -1) continue; // 갔던 길이라면 pass
                
                result[ny][nx] = result[y][x] + 1; // 이전에 온 값에서부터 +1 한칸 더!
                q.offer(new int[] {nx,ny});
                
            }
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    sb.append(0).append(" ");
                }else{
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}