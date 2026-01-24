/*
사용하고자하는 자료구조를 활용할 수 있는 방향으로 풀이하기

알아야하는 정보
- 주어진 문자의 획수
- 두 문자의 획수의 합 (10초과 시, %10로 대체)
- 현재 단계
- 결과 값 (홀수이냐 짝수이냐)
*/

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int K = S.length();
        
        int[] stroke = {
            3,2,1,2,3,3,3,3,1,1,3,1,3,
            3,1,2,2,2,1,2,1,1,2,2,2,1
        };
        
        // S를 모두 획수 배열로 바꾸기
        LinkedList<Integer> nums = new LinkedList<>();
        for (char c : S.toCharArray()) {
            nums.add(stroke[c - 'A']);
        }

        while(nums.size() > 1){
            LinkedList<Integer> next = new LinkedList<>();
            
            while(nums.size() >= 2){
                int sum = nums.poll() + nums.poll();
                next.add(sum >= 10 ? sum%10 : sum);
            }
            
            // 1개 남았을 경우, 다음 다운드로 이동
            if(!nums.isEmpty()){
                next.add(nums.poll());
            }
            nums = next;
        }
        
        if(nums.get(0)%2==0){
            System.out.println("You're the winner?");
        }else{
            System.out.println("I'm a winner!");    
        }

    }
}