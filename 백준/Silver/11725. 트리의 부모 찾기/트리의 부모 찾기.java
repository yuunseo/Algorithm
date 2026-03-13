import java.util.*; 
import java.io.*;
class Main{ 
    static ArrayList<Integer>[] arr;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b); arr[b].add(a);
        }

        visited = new boolean[N+1];
        answer = new int[N+1];
        bfs(1);

        for(int i=2; i<=N; i++){
            System.out.println(answer[i]);
        }

    }

    static void bfs(int start){
        if(visited[start]) return;

        // 현재 노드와 연결된 노드 검색
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next: arr[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    answer[next] = cur;
                    q.add(next);
                }
            }
        }

    }

}