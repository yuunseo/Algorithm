/*
현재 칸이 1이상이고, 상하좌우의 0의 개수세고, 해당 칸의 값에서 빼기 (음수면 0 양수면 그값그대로)
모든 칸을 다 돌고 난 경우, 영역의 개수 세기 -> bfs?
이때 영역의 개수가 2개 이상이 되는 경우 해당 연도를 출력
모든 칸이 0이 될 경우, 0 출력
--- 
*/
import java.util.*;
import java.io.*;

class Main{

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,M;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 기본 배열 초기화
        int year = 0; // 빙산이 녹는 연도 수
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        while(true){

            boolean[][] visited = new boolean[N][M]; // 방문 배열
            int cnt = 0; // 덩어리 개수 세기

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]>0 && !visited[i][j]){ // 바다가 아니고 이전에 방문하지 않았으면 
                        bfs(i,j,visited);
                        cnt ++; // 덩어리 개수 증가
                    }
                }
            }

            if(cnt >= 2){
                System.out.println(year);
                return;
            }

            if(cnt == 0){
                System.out.println(0);
                return;
            }

            // 1년동안 녹이기
            int[][] temp = new int[N][M];

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] > 0){
                        int sea = 0;
                        for(int d=0; d<4; d++){
                            int ny = i + dy[d];
                            int nx = j + dx[d];
                            if(ny>=0 && ny<N && nx>=0 && nx<M){
                                if(map[ny][nx] == 0) sea++;
                            }

                            temp[i][j] = Math.max(0, map[i][j] - sea);
                        }
                    }
                }
            }

            map = temp; // 1년 후 맵으로 변경
            year++;

        }
    }

    static void bfs(int i, int j, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];

                if(ny>=0 && ny<N && nx>=0 && nx<M){
                    if(map[ny][nx] > 0 && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                    }
                }
            }
        }
    }
}