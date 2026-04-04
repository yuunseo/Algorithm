import java.io.*;
import java.util.*;

public class Main {

    static class Block{
        int i,j,count;
        Block(int i, int j, int count){
            this.i=i; this.j=j; this.count=count;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] arr = new char[R][C];

        // 지훈이 이동 배열
        Queue<Block> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        // 불 확산 시간 배열
        Queue<int[]> fireQ = new LinkedList<>();
        int[][] fireTime = new int[R][C];
        for(int[] row: fireTime){
            Arrays.fill(row, -1);
        }

        for(int i=0; i<R; i++){
            String str = (br.readLine());
            for(int j=0; j<C; j++){
                arr[i][j] = str.charAt(j);

                if(arr[i][j] == 'J'){
                    q.add(new Block(i,j,0));
                    visited[i][j] = true;
                }else if(arr[i][j] == 'F'){
                    fireTime[i][j] = 0;
                    fireQ.add(new int[] {i,j});
                }
            }
        }

        while(!fireQ.isEmpty()){
            int[] cur = fireQ.poll();

            for(int d=0; d<4; d++){
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];

                if(ny<0 || nx<0 || ny>=R || nx>=C) continue;

                // 아직 불 안 온 곳 + 벽 아님
                if(arr[ny][nx] != '#' && fireTime[ny][nx] == -1){
                    fireTime[ny][nx] = fireTime[cur[0]][cur[1]] + 1;
                    fireQ.add(new int[]{ny, nx});
                }
            }
        }

        while(!q.isEmpty()){
            Block jihun = q.poll();

            // 지훈이 이동
            for(int d=0; d<4; d++){
                int ny = jihun.i + dy[d];
                int nx = jihun.j + dx[d];

                if(ny<0 || nx<0 || ny>=R || nx>=C){
                    System.out.println(jihun.count+1);
                    return;
                }

                if( arr[ny][nx] == '.' && !visited[ny][nx]){
                    if(fireTime[ny][nx] == -1 || jihun.count + 1 < fireTime[ny][nx]){
                        q.add(new Block(ny, nx, jihun.count+1));
                        visited[ny][nx] = true;
                    }

                }
            }

        }

        System.out.println("IMPOSSIBLE");

    }
}