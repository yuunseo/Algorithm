import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int y = -1, x = 0; // 시작 지점
        int num = 1;      // 채울 숫자
        
        // 방향에 따라 숫자 채우기 (i는 이동 거리)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) { // 아래로 이동
                    y++;
                } else if (i % 3 == 1) { // 오른쪽으로 이동
                    x++;
                } else { // 대각선 위로 이동
                    x--;
                    y--;
                }
                arr[y][x] = num++;
               
            }
        }
        
        // 2차원 배열을 1차원 배열로 변환
        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }
        
        return answer;
    }
}