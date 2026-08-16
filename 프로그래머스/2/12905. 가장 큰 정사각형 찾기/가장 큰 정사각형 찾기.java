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