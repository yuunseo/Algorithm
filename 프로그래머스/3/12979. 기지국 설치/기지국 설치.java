class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int prev = 0;
        int len = 2*w+1;
        for(int station: stations){
            int start = station-w;
            int end = station+w;
            
            int target = start-prev-1;
            if(target > 0){
                int a = target / len;
                int b = target % len;
                answer += (b == 0) ? a : a + 1;
            }
            
            // prev 갱신
            prev = end;
        }
                
        if(prev < n){
            int target = n-prev;
            int a = target/len; // 커버 가능한 길이
            int b = target%len; //커버 불가능해서 남는 길이
            
            answer += (b==0) ? a : a+1;
        }

        return answer;
    }
}