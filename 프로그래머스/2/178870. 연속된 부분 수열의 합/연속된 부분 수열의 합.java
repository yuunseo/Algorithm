class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {-1, sequence.length};
        
        // two pointer, prefix-sum
        int start = 0;
        int prefix = 0;
        for(int i=0; i<sequence.length; i++){
            prefix += sequence[i];
            
            if(prefix > k){ // k를 초과하면, 최소 값부터 삭제
                while( prefix >0 && prefix > k){
                    prefix -= sequence[start++];
                }
            }
            
            if( prefix == k){ // k가 되면, 정답 후보지로 추출
                answer = smallerAnswer(new int[] {start, i}, answer);
            }
        }
        
        return answer;
    }
    
    static int[] smallerAnswer(int[] target, int[] answer){
        // 길이 비교
        if(target[1]-target[0] < answer[1]-answer[0]){
            return target;
        } // 인덱스 순서 비교
        else if(target[1]-target[0] == answer[1]-answer[0]){
            if(target[0] < answer[0]) return target;
            else return answer;
        } // 더 길고, 늦은 인덱스를 가지면 원래대로 반환
        else{
            return answer;
        }
        
        
    }
}