import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
       
        // 이동을 위한 방법
        int[] dx = {-1,1,2};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {N,0}); // {시작점, 이동시간}
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];
            
            if(x==K){
                System.out.println(time);
                return;
            }
            
            // 이동 방법
            int[] next = {x-1, x+1, 2*x};
            for(int d=0; d<3; d++){
                int nx = next[d];
                if(nx<0 || nx>100000) continue;
                if(visited[nx]) continue;
                q.add(new int[] {nx,time+1});
                visited[nx] = true;
            }
            
            
        }

    }
}