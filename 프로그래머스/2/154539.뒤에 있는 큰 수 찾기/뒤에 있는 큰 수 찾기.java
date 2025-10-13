/*
- 각 원소를 선택해서 그 뒤 원소들과 비교하면서 바로 뒤 큰 수가 존재하면 해당 수를 선택, 없으면 -1
- O(N^2) : 모든 원소들을 돌아보면서 확인하기
- 해당 방법대신 stack 방법으로 다시 풀어보기
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

// class Solution {
//     public int[] solution(int[] numbers) {
//         List<Integer> answer = new ArrayList<Integer>();
//         boolean flag = false;
        
//         // 1. numbers에서 한 원소씩 불러오기
//         for(int i=0; i<numbers.length-1; i++){
//             flag = false;
//             for(int j=i+1; j<numbers.length; j++){
                
//                 // 2. i와 j(i+1) 비교하기
//                 // j가 더 크다면 answer에 추가
//                 if(numbers[i]<numbers[j]){
//                     answer.add(numbers[j]);
//                     flag=true;
//                     break;
//                 }
//             }   
//             // i보다 큰 수가 없다면 answer에 -1 추가
//             if(!flag){
//                 answer.add(-1);
//             }
//         }
        
//         // 3. 가장 마지막 수는 늘 -1을 가짐
//         answer.add(-1);
        
//         // 3. answer을 array로 변경하기
//         int[] answer_array = new int[numbers.length];
//         for(int i=0; i<numbers.length; i++){
//             answer_array[i] = answer.get(i);
//         }
        
//         return answer_array;
//     }
// }

class Solution {
    public int[] solution(int[] numbers) {
        // 결과를 담을 answer 배열
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        // index를 담을 stack 배열 
        Stack<Integer> stack = new Stack<>();
        
        // numbers 배열 한 번 순회
        for(int i=0; i<numbers.length; i++){
            
            // 스택이 비어있지 않고, 내가 지금 더 크다면 answer에다가 추가하기
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                // 뒷 큰수를 찾은 index 꺼내기
                int idx = stack.pop();
                answer[idx] = numbers[i];
                
            }
            
            // 한 바퀴 돌았으면 다음 인덱스로 이동
            stack.push(i);
            
        }
    return answer;
    }

}
