/*
크레인 N대 1분에 1박스 무게제한
모든 박스를 배로 옮기는데 드는 최솟값 구하기
N: 크레인 대수
a b c: 각 크레인의 무게제한
M: 박스의 개수

1. 각각의 크레인이 한번에 꽉 채워서 들 수 있는 경우가 있는지 확인하기
2. 최댓값부터 정렬해서, 박스의 무게가 같거나적으면 제거
3. time += 1 
4. 다음 남은 박스의 무게가 크레인보다 초과하면 실패 -1
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 크레인이 들 수 있는 무게 배열
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
        
        // 박스의 무게 배열
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box, Collections.reverseOrder());
        
        // 가장 무거운 박스를 가장 센 크레인이 못 들면 실패
        if(box.get(0) > crane.get(0)){
            System.out.println(-1);
            return;
        }
        
        // 출력할 시간
        int time = 0;
        
        while(!box.isEmpty()){
            int craneIdx = 0;
            int boxIdx = 0;

            while(craneIdx < N){
                if(boxIdx >= box.size()) break;

                if(crane.get(craneIdx) >= box.get(boxIdx)){
                    box.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }

            time++;
        }
        
        System.out.println(time);
        
    }
}