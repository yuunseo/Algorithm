import java.util.*;
import java.io.*;

class Main{

    static int N,L,H;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input initialization
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        /*
            1. 0,0에서부터 인접한 나라간의 인구수 차이를 구한다.
            2. 인접한 나라를 모두 구한 후, 각 나라의 모든 인구수와 나라의 수를 더한다.
            3. 최종 나라의 인구수를 구한다. (인접한 나라간 불가능 시, 0 출력)
        */
        int days = 0;
        
        while(true){
            visited = new boolean[N][N];
            boolean moved = false;
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        List<int[]> union = new ArrayList<>();
                        int sum = bfs(i,j,union);
                        
                        if(union.size() > 1){
                            moved = true;
                            int avg = sum / union.size();
                            
                            for(int[] pos: union){
                                arr[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }
            
            if(!moved) break;
            days++;
        }
        

        // output
        System.out.println(days);
    }

    static int bfs(int y, int x, List<int[]> union){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        visited[y][x] = true;

        union.add(new int[] {y,x});
        int sum = arr[y][x];

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(visited[ny][nx]) continue;

                int diff = Math.abs(arr[cur[0]][cur[1]] - arr[ny][nx]);
                if(L <= diff && diff <= H){
                    q.add(new int[] {ny,nx});
                    visited[ny][nx] = true;
                    union.add(new int[] {ny,nx});
                    sum += arr[ny][nx];
                }
            }
        }
        return sum;
    }
}