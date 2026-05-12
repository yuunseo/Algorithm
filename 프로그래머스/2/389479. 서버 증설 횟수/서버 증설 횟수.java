import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 필요한 서버의 개수 구하기
        ArrayList<Integer> min_servers = new ArrayList<>();
        for(int i=0; i<players.length; i++){
          min_servers.add((int) Math.ceil(players[i]/m));
        }
        
        Map<Integer, Integer> cur_servers = new HashMap<>();

        for(int i=0; i<24; i++){
            
            int cur_server = cur_servers.getOrDefault(i,0); // 현재 서버 확인
            int need_server = min_servers.get(i); // 필요한 서버 개수 확인
                        
            if(cur_server < need_server){ // 부족하면 서버 증설
                answer += (need_server-cur_server); // 증설해야 하는 서버 개수
                for(int idx = i; idx<i+k; idx++){
                    cur_servers.put(idx, cur_servers.getOrDefault(idx,0)+(need_server-cur_server));
                }
            }else{ // 충분하면 pass & 서버 시간 감소
                continue;
            }
        }
        
        return answer;
    }
    
}