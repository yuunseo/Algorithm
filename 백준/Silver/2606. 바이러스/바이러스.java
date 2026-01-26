/*
네트워크로 연결된 컴퓨터 감염 -> 너비우선 -> BFS -> 맵, 방문배열, 정답 자료구조 필요
while(큐가 비어있지 않을 때까지 반복)

Queue의 인터페이스 구현체
- LinkedList: 인덱스가 있는 큐 (중간에서 삽입/삭제 많을 때)
- PriorityQueue: 우선순위에 따라 순서
- ArrayDeque ,,,: 인덱스가 있는 큐 (앞뒤에서 삽입/삭제 많을 때)
*/
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int T = Integer.parseInt(br.readLine()); // 연결 수
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int net = Integer.parseInt(st.nextToken());
            graph.get(com).add(net);
            graph.get(net).add(com); // 양방향 네트워크
        }
        
        boolean[] visited = new boolean[N + 1]; // 방문배열
        Queue<Integer> q = new ArrayDeque<>(); // 자료구조
        
        q.offer(1); // // 1번 컴퓨터에서부터 시작
        visited[1] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            // 해당 컴퓨터와 연결된 컴퓨터를 큐에 저장
            for(int next: graph.get(cur)){ 
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
        
    }
}
