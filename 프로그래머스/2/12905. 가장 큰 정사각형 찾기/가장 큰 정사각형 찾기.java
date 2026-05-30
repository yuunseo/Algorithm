//  // 1-> 완전탐색 case
// class Solution
// {
//     public int solution(int [][]board)
//     {
//         int answer = 0;
        
//         int h = board.length;
//         int w = board[0].length;
//         int maxSize = Math.min(h,w); // 이보다 큰 정사각형은 불가능함.
        
//         for(int i=0; i<h; i++){
//             for(int j=0; j<w; j++){
//                 // (i,j)는 시작 좌표
//                 int type = board[i][j];
                
//                 if(type == 0) continue;
                
//                 for(int k=0; k<maxSize; k++){
//                     boolean isSuccess = true;
//                     // (i+k,j+k)은 정사각형이 될 수 있는 좌표
//                     if(i+k >= h || j+k >= w) break;
//                     int newType = board[i+k][j+k];
                    
//                     // 1. 다음 크기의 정사각형이 가능한가?
//                     if(type != newType){
//                         break; // 불가능하면, 다음 타겟 좌표로 이동
//                     }
                    
//                     // 2. 크기에 해당하는 모든 칸들 비교
//                     for(int y=i; y<=i+k; y++){
//                         for(int x=j; x<=j+k; x++){
//                             int inType = board[y][x];
//                             if(inType != type){
//                                 isSuccess = false;
//                                 break; // 내부에 다른 숫자가 있으면 실패!
//                             }
//                         }
                        
//                         if(!isSuccess) break;
//                     }
                    
//                     // 3. 정사각형이 존재하면, 크기 갱신
//                     if(isSuccess){
//                         answer = Math.max(answer, (k+1)*(k+1));
//                     }
//                 }
                
                
//             }
//         }
        

//         return answer;
//     }
// }

class Solution {
    public int solution(int[][] board) {

        int h = board.length;
        int w = board[0].length;

        int max = 0;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){

                if(board[i][j] == 1){

                    if(i > 0 && j > 0){

                        board[i][j] =
                            Math.min(
                                board[i-1][j],
                                Math.min(
                                    board[i][j-1],
                                    board[i-1][j-1]
                                )
                            ) + 1;
                    }

                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return max * max;
    }
}