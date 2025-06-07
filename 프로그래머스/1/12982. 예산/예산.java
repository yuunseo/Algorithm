/*
<아이디어>
-> d를 정렬해서, budget이 0보다 작아지기 전까지 빼기!
*/

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        
        // 숫자 배열 정렬하기
        Arrays.sort(d);
        
        // budget에서 하나씩 빼고, 카운트 증가
        int answer = 0;
        int temp;
        for(int i=0; i<d.length; i++){
            temp = budget - d[i];
            if(temp>=0){
                answer++;
                budget = temp;
            }else{
                break;
            }
        }
        return answer;
    }
}