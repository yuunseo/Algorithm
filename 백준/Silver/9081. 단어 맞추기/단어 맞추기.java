/*
알파벳들의 모든 조합 -> 사전 정렬 -> 기본단어 그 다음 단어를 찾자.
그러기 위해서 우리가 해야 하는 순서는
1. 순서가 변경될 가능성이 있는 인덱스 찾기 = 작은 수가 더 앞에 있는 경우
2. 찾은 더 작은 수를 그 다음으로 큰 수  (그 뒤 인덱스들 중 가장 작은 수)를 찾기
3. 그 두 수의 위치를 바꾸고, 남은 부분을 오름차순 정렬하기

*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int idx=0; idx<N; idx++){
            char[] arr = br.readLine().toCharArray();
            
            int pivot = -1;
            
            // 1. pivot 찾기
            for(int i=arr.length-1; i>0; i--){
                if(arr[i-1] < arr[i]){
                    pivot = i-1;
                    break;
                }
            }
            
            if(pivot == -1){
                System.out.println(new String(arr));
                continue;
            }
            
            // 2. next 찾기 (뒤에서부터)
            int next = arr.length - 1;
            for(int i=arr.length-1; i>pivot; i--){
                if(arr[pivot] < arr[i]){
                    next = i;
                    break;
                }
            }
            
            // 3. swap
            char temp = arr[pivot];
            arr[pivot] = arr[next];
            arr[next] = temp;
            
            // 4. reverse
            int left = pivot+1;
            int right = arr.length-1;
            
            while(left < right){
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
            
            System.out.println(new String(arr));
        }
    }
}
