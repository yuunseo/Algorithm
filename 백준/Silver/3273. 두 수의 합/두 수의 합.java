import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine()); // 타겟
        Arrays.sort(arr);
        
        // x 찾기
        int left = 0;
        int right = n-1;
        int count = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(sum < x){
                left ++;
            }else if(sum > x){
                right--;
            }else{
                count++;
                left++; right--;
            }
        }
        
        
        System.out.println(count); // 중복 제거
        
    }
}