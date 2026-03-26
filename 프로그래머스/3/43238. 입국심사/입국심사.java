class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int time: times){
            min = Math.min(min, time);
            max = Math.max(max, time);
        }
        
        long left = min*1;
        long right = max*n;
        
        while(left<=right){
            long mid = (left+right)/2;
            long sum = 0;
            for(int time: times){
                sum += (mid/time);
            }
            
            if(sum < n){
                left = mid+1;
            }else{
                answer = mid;
                right = mid-1;
            }
        }
        
        
        return answer;
    }
}