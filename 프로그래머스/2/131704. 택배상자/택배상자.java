import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        // 대기 컨베이어
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=order.length; i++){
            q.add(i);
        }
        
        // 보조 컨베이어
        Stack<Integer> stack = new Stack<>();
        
        // 하나씩 확인하기
        for(int num: order){
            if(q.isEmpty() || q.peek() > num){ // 컨베이어에 없고, 이미 보조 칸으로 이동했음
                if(num == stack.peek()){
                    stack.pop();
                    answer++;
                }else{
                    break;
                }
            }else if(q.peek() <= num){   
                // 컨베이어에 있다는 의미이므로, 꺼내기
                int convey = q.peek();
                while(convey != num){
                    stack.push(q.poll());
                    convey = q.peek();
                }
                q.poll();
                answer ++;
            }
        }
        
        return answer;
    }
}