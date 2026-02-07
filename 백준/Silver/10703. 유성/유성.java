/*
유성 X 땅 # 공기 .
유성과 땅의 거리들 중 가장 짧은 거리만큼 그대로 내려오면 됨
1. 하나씩 읽으면서 각 열별로 유성의 위치랑 땅의 높이를 저장하면 됨 -> int[] starts, int[] bottoms
2. 유성은, 기존 값보다 크면 갱신 / 땅은, 기존 값보다 작으면 갱신
3. 다 돌고 나면, 각 열별로 유성-땅의 길이를 구해서 젤 짧은 게 먼지 구하기
4. 젤 짧은 길이만큼 유성을 아래로 내리면 됨 -> y좌표를 이동시키고 원래 자리에는 .으로 변경
5. 
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][S]; // 기본 지도 배열
        List<int[]> meteors = new ArrayList<>();
        int[] stars = new int[S]; // 유성 위치 배열
        int[] bottoms = new int[S]; // 땅 위치 배열
        Arrays.fill(bottoms, R);

        // 지도 그리기 && 유성과 땅의 위치 초기화
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<S; j++){
                map[i][j] = str.charAt(j);

                if(str.charAt(j) == 'X'){
                    stars[j] = Math.max(stars[j],i); //더 아래에 놓인 유성으로 갱신
                    meteors.add(new int[]{i, j});
                }

                if(str.charAt(j) == '#'){
                    bottoms[j] = Math.min(bottoms[j],i);// 더 위에 놓인 땅으로 갱신
                }
            }
        }

        // 가장 짧은 거리 구하기 (가장 먼저 떨어질 수 있는 유성)
        int dist = R;
        for(int i=0; i<S; i++){
            int diff = bottoms[i] - stars[i] - 1;
            if (stars[i] == 0 && map[0][i] != 'X') continue;

            if(dist > diff){
                dist = diff; // 최소 길이로 갱신
            }
        }

        // dist 거리만큼 유성을 수직으로 이동
        for(int i=0; i<R; i++){
            for(int j=0; j<S; j++){
                if(map[i][j] == 'X'){
                    map[i][j] = '.';
                }
            }
        }

        for(int[] m : meteors){
            int ny = m[0] + dist;
            int nx = m[1];
            map[ny][nx] = 'X';
        }


        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            for(int j=0; j<S; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
