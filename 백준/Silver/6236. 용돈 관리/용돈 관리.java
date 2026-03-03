/*
1. 통장에서 K원 인출 : 충분하면 그대로, 모자라면 남은 금액은 통장에 넣고 다시 K원 인출
2. 정확히 M번 인출할 거임
3. K를 최소화할 수 있게 하자

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int min = 0; // 가장 큰 지출
        int max = 0; // 모든 지출의 합
        int answer = max;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        while(min <= max){
            int count = 1;
            int mid = (min+max)/2;
            int money = mid;

            for(int i=0; i<N; i++){
                if(arr[i] > money){
                    count++;
                    money = mid;
                }
                money -= arr[i];
            }
            
            if(count <= M){
                max = mid-1;
                answer = mid;
            }else{
                min = mid+1;
            }
        }

        System.out.println(answer);
    }
}