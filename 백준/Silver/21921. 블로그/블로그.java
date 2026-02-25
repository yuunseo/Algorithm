import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        
        // 1. 처음 X일 합 구하기
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }
        
        int max = sum;
        int count = 1;
        
        // 2. 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            sum = sum - arr[i - X] + arr[i];

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }
        
        if(max == 0){
            System.out.println("SAD");
            return;
        }else{
            System.out.println(max+"\n"+count);
            return;
        }
        
    }
}