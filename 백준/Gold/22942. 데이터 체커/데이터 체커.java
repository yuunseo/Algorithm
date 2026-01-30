import java.util.*;
import java.io.*;

class Main{
    static class Circle{
        int left, right;
        Circle(int left, int right){
            this.left=left; this.right=right;
        }
    } 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Circle[] circles = new Circle[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circles[i] = new Circle(x - r, x + r);
        }
    
        // 왼쪽 기준 정렬
        Arrays.sort(circles, (a, b) -> {
            if (a.left == b.left) return b.right - a.right;
            return a.left - b.left;
        });
    
        Stack<Circle> stack = new Stack<>();   
        
        // 정렬된 상태이므로, 왼쪽 원부터 처리
        for(Circle cur: circles){
            
            // 이전 원의 외부에 있으면, 더이상 비교하지 않아도 되므로 pop
            while( !stack.isEmpty() && stack.peek().right<=cur.left){
                stack.pop();
            }
            
            // 이전 원의 내부에 있으면, 겹치는지 확인 필요
            if(!stack.isEmpty()){
                Circle top = stack.peek();
                
                if(cur.left<=top.right && top.right<=cur.right){
                    System.out.println("NO");return;
                }
            }
            
            // 겹치지 않으면, 검사 대상으로 push
            stack.push(cur);
        }
        
        // 결과 출력
        System.out.println("YES");
        
    }
}