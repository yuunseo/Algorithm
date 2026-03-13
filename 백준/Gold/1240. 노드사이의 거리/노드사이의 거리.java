import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited;
    static ArrayList<int[]>[] arr;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new int[] {b,c});
            arr[b].add(new int[] {a,c});
        }

        // 구하고자 하는 두 노드 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            answer=0;
            visited = new boolean[N+1];
            dfs(start, end,0);
            System.out.println(answer);
        }

    }

    static void dfs(int start, int end, int len){

        // 종료 노드에 도착하면, 종료
        if(start == end){
            answer = len;
            return;
        }

        // start와 연결된 다음 노드로 이동
        visited[start] = true;

        for(int[] next: arr[start]){
            if(!visited[next[0]]){
                dfs(next[0], end, len+next[1]);
            }
        }

    }
}