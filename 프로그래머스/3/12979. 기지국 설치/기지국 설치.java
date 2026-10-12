class Solution {
    public int solution(int n, int[] stations, int w) {
        // 자료구조 초기화
        int internet = 2*w +1;
        int answer = 0;
        int start = 1;
        int end = 1;
        
        // 설치된 기지국으로 전파되는 아파트 파악하기
        for(int i=0; i<stations.length; i++){
            // 종료 조건
            if(start > n) break;
            
            int part1 = stations[i] - w;
            int part2 = stations[i] + w;
            
            if(end < part1){
                end = part1-1;
                answer += (end-start+1) / internet;
                if((end-start+1) % internet != 0) answer += 1;
            }
            
            // 다음 아파트 구간 구하기
            start = part2+1;
            end = part2+1;
            
        }
        
        if(end <= n){ // 마지막 아파트에 도착하지 않았으면, 마저 계싼
            answer += (n-start+1) / internet;
            if((n-start+1) % internet != 0) answer += 1;
        }
        
        // 결과 반환
        return answer;
        
        
        
    }
}