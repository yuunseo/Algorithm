import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int result = 0; // 터진 인형의 수
        Stack<Integer> stack = new Stack<>(); // 바구니
        int n = board.length; // 게임판의 길이
        
        for(int move: moves){
            move-=1; // zero base로 맞추기
            
            // 인형 뽑기 수행
            for(int i=0; i<n; i++){
                int target = board[i][move];
                if(target != 0){
                    if(!stack.isEmpty() ){ // 바구니에 넣기 전, 바구니 확인
                        int top = stack.peek();
                        if(top == target){
                            result += 2; // 두 개의 인형 터짐
                            stack.pop();
                        }else{
                            stack.push(target);
                        }
                        
                    }else{
                        stack.push(target);
                    }
                    
                    board[i][move] = 0;// 게임판에서 삭제
                    break;
                }
                
            }
        }
        
        return result;
        
        
    }
}