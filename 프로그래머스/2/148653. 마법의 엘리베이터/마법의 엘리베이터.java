class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int cur = storey % 10;
            int next = (storey / 10) % 10;
            
            if(cur > 5){ // 10과 가까우면 올림
                storey += 10;
                answer += (10-cur);
            }
            else if(cur < 5){ // 0과 가까우면 내림
                answer += cur;
            }
            else{ // 5인 경우, 다음 자릿수까지 보고 결정
                if(next >= 5){
                    storey += 10;
                    answer += 5;
                }else{
                    answer += 5;
                }  
            }
            
            storey /= 10; // 맨 뒷자릿수는 제거
        }
        
        return answer;
    }
}