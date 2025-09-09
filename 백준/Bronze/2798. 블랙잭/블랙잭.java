/*
N개의 카드를 갖고 이 카드의 합이 M을 넘지 않는 한도 내에서, 3장을 고른다. 
3장의 합은 M을 넘지 않는 최대 값이어야 한다.
그럼 우선 N개 중에서 3개를 고르는 조합 -> 그 조합들 중에서 M과 가장 가깝게 하지만 넘지는 않게.
1. 모든 조합을 구해서, M과 비슷한 수를 고르는 경우: 100개중의 조합이므로, 가능
*/

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. N과 M 입력받기
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // 2. N개의 카드 배열 생성
        int[] cards = new int[N];
        for(int i = 0; i < N; i++){
            cards[i] = scanner.nextInt();
        }
        
        // 3. N개 중 3개의 카드 조합 생성
        int maxSum = 0;
        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    // 3개의 카드 조합이, max를 넘지 않는 최대 값인지 판별
                    if(sum <= M && sum > maxSum){
                        maxSum = sum;
                    }
                }
            }
        }
        
        // 4. 정답 출력
        System.out.println(maxSum);
    }
}