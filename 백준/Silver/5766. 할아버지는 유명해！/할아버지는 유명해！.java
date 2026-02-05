/*
랭킹 정보 리스트를 바탕으로 2등 선수를 알아내자
1. N주동안 상위 M명의 랭킹 정보, 각 주별로 랭킹 정보가 띄어쓰기 단위로 제공
2.0,0 으로 입력될 때까지 반복
3. 2등인 선수가 여러 명일 수 있으므로, 저장을 해 둬야됨.
4. priority queue에 거꾸로 넣어서 2번째를 출력하면 되려나?
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            if(N==0 && M==0) break;
            
            // N주동안의 선수들의 랭킹 저장
            Map<Integer,Integer> rank = new TreeMap<>();
            int max = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    int player = Integer.parseInt(st.nextToken());
                    rank.put(player, rank.getOrDefault(player,0)+1);
                }
            }
            
            // 점수 기준 정렬
            Set<Integer> scoreSet = new HashSet<>(rank.values());
            List<Integer> scores = new ArrayList<>(scoreSet);
            scores.sort(Collections.reverseOrder());
            
            int second = scores.get(1);
            
            
            // 2순위 선수 찾기
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : rank.entrySet()) {
                if (entry.getValue() == second) {
                    sb.append(entry.getKey()).append(" ");
                }
            }

            // 출력하기
            System.out.println(sb.toString().trim());
            
        }
    }
}