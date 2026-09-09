/*
[아이디어]
1. 하나씩 돌면서 최대/최솟값 갱신하기 - O(N)
2. 가로 최댓값 길이 * 세로 최댓값 길이 - O(1)
*/
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int maxWidth = 0;
        int maxLength = 0;
        for(int[] size: sizes){
            int width = Math.max(size[0], size[1]);
            int length = Math.min(size[0], size[1]);
            
            maxWidth = Math.max(width, maxWidth);
            maxLength = Math.max(length, maxLength);
        }
        
        return maxWidth * maxLength;
    }
}