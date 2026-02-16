/*
N개의 회의를 모두 진행할 수 있는 최소 회의실의 개수 구하기
시작시간-종료시간
1. 시작시간 기준 오름차순 정렬
2. 필요한 강의실의 개수를 찾아야하므로 큐에다가 강의실의 개수 구하기 = 종료 시간 담기
3. 종료 시간을 하나씩 담고, 남은 강의의 시작 시간과 비교하기
    - 시작 시간이 같거나 늦다면, 강의실을 같이 써도 되니까 poll하고 add
    - 시작 시간이 더 이르다면, 강의실을 같이 쓸 수 없으니까 add
4. 모든 강의 다 돌면 큐에 남아있는 강의 개수를 return
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2]; // 시작시간, 종료시간
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬하기
        Arrays.sort(list, (a,b)->{
            if(a[0] == b[0]) return a[1]-b[1]; // 시작시간이 같으면 종료시간으로 정렬
            return a[0]-b[0]; // 시작시간으로 정렬
        });
        
        // 강의실의 개수 구하기 위해서 큐에 넣기
        Queue<Integer> answer = new PriorityQueue<>();
        answer.add(list[0][1]);
        
        for(int i=1; i<N; i++){
            int nextStart = list[i][0];
            int curEnd = answer.peek();
            
            if(curEnd <= nextStart){
                answer.poll();
            }
            answer.add(list[i][1]);
        }
        
        // 출력
        System.out.println(answer.size());
        
    }
}