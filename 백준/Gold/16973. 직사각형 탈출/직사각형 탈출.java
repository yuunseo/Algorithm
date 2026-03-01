/*
1. 인풋 초기화 N,M/ H,W
2. 직사각형의 모든 영역을 이동시켜서, 그 자리에 벽이 있는지 확인해야함?


*/
import java.util.*;
import java.io.*;

class Main{

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1]; // (1,1)부터 시작
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine()); 
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] start = new int[2];
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());
        int[] finish = new int[2];
        finish[0] = Integer.parseInt(st.nextToken());
        finish[1] = Integer.parseInt(st.nextToken());

        // 누적합 구하기
        int[][] prefix = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                prefix[i][j] = map[i][j] 
                    + prefix[i-1][j]
                    + prefix[i][j-1]
                    - prefix[i-1][j-1];

            }
        }

        int answer = bfs(H, W, start, finish, N, M, prefix);
        System.out.println(answer);


    } 

    static boolean canMove(int r, int c, int H, int W, int N, int M, int[][] prefix){
        int r2 = r+H-1;
        int c2 = c+W-1;

        // 범위 점검
        if(r2 < 1 || c2 < 1 || r2 > N || c2 > M) return false;

        // 범위 내 벽 개수 총합
        int sum = prefix[r2][c2] - prefix[r-1][c2] - prefix[r2][c-1] + prefix[r-1][c-1];
        return sum == 0;
    }

    static int bfs(int H, int W, int[] start, int[] finish, int N, int M, int[][] prefix){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][M+1];

        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r == finish[0] && c == finish[1]){
                return dist;
            }

            for(int d=0; d<4; d++){
                int nr = r + dx[d];
                int nc = c + dy[d];

                if(nr >= 1 && nc >= 1 && nr <= N && nc <= M){
                    if(!visited[nr][nc]
                       && canMove(nr, nc, H, W, N, M, prefix)){

                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc, dist+1});
                    }
                }
            }
        }

        return -1;
    }

}