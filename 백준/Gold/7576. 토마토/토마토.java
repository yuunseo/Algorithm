/*
모든 토마토가 다 익는 최소 일수는?
1.토마토 기본 배열 저장하기, 익지 않은 토마토의 개수 저장해두기
2. BFS를 이용해서, 인접 칸들의 상태 변화 & 다음 변화 대기자로 삽입
3. 더이상 고려하지 않은 대기자들이 없을 경우, 익지 않은 토마토의 개수가 아직 남아있으면 -1 출력
4. -1는 고려 X

*/

import java.util.*;
import java.io.*;

class Main{
    
    static int[] dx = new int[] {0,0,-1,1};
    static int[] dy = new int[] {-1,1,0,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 입력 초기화
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // 기본 맵 & 변수 초기화
        int[][] tomatos = new int[N][M];
        int nonTomatos = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 0) nonTomatos ++;
                if(cur == 1) q.add(new int[] {i,j,0});
                tomatos[i][j] = cur;
            }
        }
        
        // 자료구조 초기화
        boolean[][] visited = new boolean[N][M];
        int days = 0;
        
        // 익은 토마토에서 출발
        while(!q.isEmpty()){
            int[] cur = q.poll();
            days = Math.max(days, cur[2]); // 걸리는 시간 갱신
            
            // 현재 토마토의 상하좌우 판단 후, 추가
            for(int d=0; d<4;d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                
                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                
                if(tomatos[ny][nx] == 0){ // 인접 칸이 0일 경우, 1로 변경
                    tomatos[ny][nx] = 1;
                    nonTomatos--;
                    q.add(new int[] {ny,nx, cur[2]+1}); // 다음 인접칸 확인을 위해 큐에 삽입
                }
                
                // 1 혹은 -1 칸이라면, 아무런 동작 없음
            }
        }
        
        // 남은 토마토에 따라 결과 처리
        if(nonTomatos > 0){
            System.out.println(-1);
        }else{
            System.out.println(days);
        }
        
    }
}