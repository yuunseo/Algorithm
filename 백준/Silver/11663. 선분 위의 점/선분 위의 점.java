import java.util.*;
import java.io.*;

class Main{
    static int[] dots;
    static int N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 점의 좌표
        dots = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            dots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots);
        
        // 선분
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int leftIdx = lowerBound(start);
            int rightIdx = upperBound(end);
            
            sb.append(rightIdx - leftIdx).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int lowerBound(int target){
        int left = 0;
        int right = N;
        
        while(left < right){
            int mid = (left+right)/2;
            
            if(dots[mid] >= target){ // 처음으로 target 이상이 되는 인덱스 찾기
                right = mid;
            }else{
                left = mid+1;
            }
        }
        
        return left;
    }
    
    static int upperBound(int target){
        int left = 0;
        int right = N;
        
        while(left < right){
            int mid = (left+right)/2;
            
            if(dots[mid] > target){ // 처음으로 target을 초과하는 인덱스 찾기
                right = mid;
            }else{
                left = mid+1;
            }
        }
        
        return left;
    }
    
    
}