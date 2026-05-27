import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        // col번째 컬럼을 기준으로 튜플 오름차순 정렬하기
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return Integer.compare(a[col - 1], b[col - 1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        // S_i = SUM(data[i][?] % i)
        int result = 0;
        for(int i = row_begin; i <= row_end; i++){
            int temp = 0;
            for(int j=0; j<data[0].length; j++){
                temp += (data[i-1][j] % i);
            }
            result ^= temp;
        }
        
        return result;
    }
}