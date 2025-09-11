import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // 1. N과 M 입력
        int N = scanner.nextInt(); // 행
        int M = scanner.nextInt(); // 열
        scanner.nextLine(); // 버퍼 비우기
        
        int min = N * M; // 최대값으로 초기화
        
        // 2. map 입력하기
        String[] map = new String[N];
        for(int i=0; i<N; i++){
            map[i] = scanner.nextLine(); // split() 제거
        }
        
        // 3. 8*8 크기 자르면서 최소 cnt 계산
        for(int i=0; i<=N-8; i++){ 
            for(int j=0; j<=M-8; j++){ 
                int cnt1 = 0; // W로 시작
                int cnt2 = 0; // B로 시작

                for(int x=i; x<i+8; x++){
                    for(int y=j; y<j+8; y++){
                        char c = map[x].charAt(y);

                        // W로 시작할 때
                        if((x + y) % 2 == 0){
                            if(c != 'W') cnt1++;
                            if(c != 'B') cnt2++;
                        } else {
                            if(c != 'B') cnt1++;
                            if(c != 'W') cnt2++;
                        }
                    }
                }

                min = Math.min(min, Math.min(cnt1, cnt2));
            }
        }
        
        // 결과 출력
        System.out.println(min);
    }
}
