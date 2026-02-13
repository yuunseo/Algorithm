/*
1선택 시 최대 2개
총 N개의 운동기구를 모두 한 번 이상씩 원함
근손실 정도는 M까지 허용 초과 불가능!

아래 두 가지를 고려해야 함
1. N개의 운동기구를 2개씩 선택
2. 2개 운동기구의 조합으로 인한 근손실 정도의 총합
>>> 즉, 서로 다른 2개의 조합으로 근손실 정도의 최소를 구하는 2개씩의 조합 구하기

여기서 내가 최대한으로 구할 수 있는 것
1. 홀수라면, 가장 큰 값을 혼자쓰고 나머지 최소+최대 조합으로 모으기
2. 짝수라면, 최소+최대 조합으로 중화시키기
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 오름차순으로 정렬된 근손실 정도 배열
        ArrayList<Long> m = new ArrayList<>();
        for(int i=0; i<N; i++){
            m.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(m);

        // 갱신
        long max = 0;
        if(N % 2 == 0){
            for(int i=0; i<N/2; i++){
                max = Math.max(max, m.get(i) + m.get(N-1-i));
            }
        } else {
            max = m.get(N-1); // 가장 큰 값 혼자
            for(int i=0; i<N/2; i++){
                max = Math.max(max, m.get(i) + m.get(N-2-i));
            }
        }
        
        // 결과 출력
        System.out.println(max);

    }
}