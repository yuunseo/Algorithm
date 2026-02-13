/*
유제품 3개 중 젤 싼건 제외한 값만 지불
N팩의 유제품을 살건데 최소비용으로
-> 가장 줄일 수 있는 부분 찾기
비싼것들끼리 3개씩 모으기, 싼 것들은 개별로 사도 되게끔
1. 내림차순 정렬
2. 3개씩 묶, 2개만 추가
3. 남는 것들은 모두 추가

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> milk = new ArrayList<>();
        for(int i=0; i<N; i++){
            milk.add(Integer.parseInt(br.readLine()));
        }
        
        // 내림차순 정렬 3 3 2 2
        Collections.sort(milk, Collections.reverseOrder());
        int cost = 0;
        for(int i=0; i<N; i++){
            if(i%3 < 2){
                cost += milk.get(i);
            }
        }
        
        // 결과 출력
        System.out.println(cost);
    }
}