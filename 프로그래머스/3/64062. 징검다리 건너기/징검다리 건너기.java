class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0; 
        
        int min = 1;
        int max = 200000000;
        
        while(min <= max){
            int mid = (min+max)/2;
            
            if(aboutNext(stones, k, mid)){
                answer = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return answer;
    }
    
    static boolean aboutNext(int[] stones, int k, int mid){
        
        int count = 0;
        for(int stone: stones){
            if(stone-mid<0){
                count++;
                if(count >= k) return false;
            }else{
                count = 0;
            }
        }
        
        return true;
    }
    
}