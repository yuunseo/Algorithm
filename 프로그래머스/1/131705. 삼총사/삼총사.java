/*
-> 3개를 더해서 0이 되는 경우의 수 모두 구하기
1. 정렬 후 투포인터로 계산해보려고 했으나, 2개 비교가 아닌 3개 비교여서 포기
2. 반복문 3개?
*/
import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    int sum = number[i] + number[j] + number[k];
                    
                    if(sum == 0) answer++;
                }
            }
        }
        
        return answer;
    }
}