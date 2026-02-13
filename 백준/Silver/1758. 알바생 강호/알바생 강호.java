/*
팁 액수: 원래돈-등수+1 >= 0 인 경우, 추가
순서를 바꿔서 받을 수 있는 팁의 최댓값 구하기
1. 어떤 것을 줄여야 받을 수 있을까?
 - 팁 액수가 적은 사람을 먼저 받아야 가능성이 커지지만, 그래봤자 적은 돈임
 - 그래서 그냥 최대한 큰 수부터 먼저 받고 적은 돈은 포기!

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        // 돈의 금액이 많은 사람부터 정렬하기
        ArrayList<Integer> people = new ArrayList<>();
        for(int i=0; i<N; i++){
            people.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(people, Collections.reverseOrder());
        
        // 받을 수 있는 모든 팁 덧셈
        long total = 0;
        for(int i=0; i<people.size(); i++){
            int money = people.get(i) - (i+1) + 1;
            if(money<0) continue;
            else total += money;
        }
        
        // 결과 출력
        System.out.println(total);
    }
}