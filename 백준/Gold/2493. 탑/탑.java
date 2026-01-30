import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1~500,000
        StringBuilder sb = new StringBuilder();
        
        // 탑의 높이를 저장할 자료구조: [높이, 순서]
        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        stack.push(new int[] {0,0});
        
        for(int i=1; i<=N; i++){
            int[] cur = {Integer.parseInt(st.nextToken()),i};
            
            boolean search = false;
            while(!stack.isEmpty()){
                int[] prev = stack.peek();
                // 이전 신호탑의 높이가 나보다 낮으면, 그 전 신호탑과 비교
                if(prev[0] < cur[0]){ 
                    stack.pop();
                    continue;
                } // 나보다 높은 신호탑일 경우, 해당 인덱스로 출력 후 반복문 종료
                else{
                    sb.append(prev[1]).append(" ");
                    stack.push(cur);
                    search = true;
                    break;
                }
            }
            
            // 나보다 높은 신호탑을 못 찾은 경우, 0 출력
            if(!search){
                sb.append(0).append(" ");
                stack.push(cur);
            }
            
        }
        
        // 결과 출력
        System.out.println(sb);
        
    }
}