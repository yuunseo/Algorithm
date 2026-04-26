import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] game = new char[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                game[i][j] = board[i].charAt(j);
            }
        }

        while(true){

            boolean removed = false;
            char[][] temp = new char[m][n];

            for(int i=0; i<m; i++){
                temp[i] = game[i].clone();
            }

            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){

                    char now = game[i][j];

                    if(now == '-') continue;

                    if(now == game[i][j+1]
                    && now == game[i+1][j]
                    && now == game[i+1][j+1]){

                        temp[i][j] = '-';
                        temp[i][j+1] = '-';
                        temp[i+1][j] = '-';
                        temp[i+1][j+1] = '-';

                        removed = true;
                    }
                }
            }

            if(!removed) break;

            for(int i=0; i<n; i++){
                Stack<Character> stack = new Stack<>();

                for(int j=0; j<m; j++){
                    if(game[j][i] != '-' && temp[j][i] == '-'){
                        answer++;
                    }else if(temp[j][i] != '-'){
                        stack.push(temp[j][i]);
                    }
                }

                for(int j=m-1; j>=0; j--){
                    if(stack.isEmpty()){
                        game[j][i] = '-';
                    }else{
                        game[j][i] = stack.pop();
                    }
                }
            }
        }

        return answer;
    }
}