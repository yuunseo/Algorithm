class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        
        long answer = Long.MIN_VALUE;
        
        long sum1 = 0; // 짝수 +
        long sum2 = 0; // 짝수 -
        
        long min1 = 0;
        long min2 = 0;
        
        for(int i=0; i<len; i++){
            int val = sequence[i];
            
            if(i % 2 == 0){
                sum1 += val;
                sum2 -= val;
            } else {
                sum1 -= val;
                sum2 += val;
            }
            
            answer = Math.max(answer, sum1 - min1); // 서로 뺐을 때 가장 큰 부분 수열
            answer = Math.max(answer, sum2 - min2);
            
            min1 = Math.min(min1, sum1);
            min2 = Math.min(min2, sum2);
        }
        
        return answer;
    }
}