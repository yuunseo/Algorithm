/*
<아이디어>
1. i~j번 아이템을 정렬해야 한다.
2. 결과 배열은 commands.length()만큼의 크기로 만들면 된다!
3. 
*/
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];// 결과 배열
        
        int i,j,k;
        for(int idx=0; idx<commands.length; idx++){ // commands에서 하나씩 불러오기
            i = commands[idx][0];
            j = commands[idx][1];
            k = commands[idx][2];
            
            int[] temp = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(temp);
            answer[idx] = temp[k-1];
        }
        return answer;
    }
}