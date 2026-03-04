/*
구해야 하는 값
- 치즈 영역의 가장자리 인덱스
- 치즈 영역의 개수
- 녹는 시간 
아이디어
1. 1인 영역을 모두 구한다 (큐) -> 치즈 영역의 개수
2. (0,0) -> 가장자리를 돌면서 큐에 넣으면서 0인 영역을 넓혀간다
3. 이때 1을 만나면, 복사된 배열에다가 0으로 바꾼다 && visited = true
4. 모든 가장자리가 visited되면 종료 -> 녹는시간++
5. 다시한번 치즈 영역을 돌면서 visited인거 제외 -> 치즈 영역의 개수
*/
import java.util.*;
import java.io.*;

class Main{
    static int N,M;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int prevCheeseCount;
    static int curCheeseCount;
    static int hour;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        Queue<int[]> cheese = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    cheese.add(new int[] {i,j});
                }
            }
        }
        
        // 치즈 영역의 개수
        prevCheeseCount = cheese.size();
        curCheeseCount = cheese.size();
        
        // 가장자리 돌면서 치즈 녹이기
        while(curCheeseCount !=0){
            bfs();
        }
        
        System.out.println(hour);
        System.out.println(prevCheeseCount);
        
    }
    
    static void bfs(){
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            copy[i] = arr[i].clone();
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[] {0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(nx<0||ny<0||nx>=M||ny>=N) continue;
                
                if(!visited[ny][nx] && copy[ny][nx] == 0){
                    q.add(new int[] {ny,nx});
                    visited[ny][nx] = true;
                }else if(!visited[ny][nx] && arr[ny][nx] == 1){
                    copy[ny][nx] = 0;
                    visited[ny][nx] = true;
                }
            }
        }
        
        // 남은 치즈의 개수 세기
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M ;j++){
                if(copy[i][j] == 1) count++;
            }
        }
        prevCheeseCount = curCheeseCount;
        curCheeseCount = count;
        arr = copy;
        hour++;
    }
}