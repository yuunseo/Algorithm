/*
1. 구간의 점수의 최댓값들을 최소로 하려고 한대.
2. 구간의 |최대-최소|값을 최소로 하기 위해서는 최대&최소가 차이가 많이 안 나야함
3. 우선 내가 알아야 하는 것들
    - 나눌 수 있는 구간의 경우의 수: 모든 경우의 수를 구하기에는 너무 복잡함. 다른 방법이 있을까?
    - 구간에 대한 구간의 점수: list에 넣어서 max, min 구한 후, 차이 구하는 방법?
    - 각 경우의 수에 따른 각 구간별 최댓값: 위에서 구한 차이들 중 Math.max를 이용하여 최댓값 저장하기
    - 최댓값들 중, 최솟값: 위에서 최댓값이 산정되면 Math.min을 이용하여 최솟값을 저장하기

*/
import java.util.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxVal = 0;
        int minVal = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            maxVal = Math.max(maxVal, arr[i]);
            minVal = Math.min(minVal, arr[i]);
        }

        int left = 0;
        int right = maxVal - minVal;
        int answer = right;

        while(left <= right){

            int mid = (left + right) / 2;

            if(check(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean check(int mid){

        int count = 1;
        int max = arr[0];
        int min = arr[0];

        for(int i = 1; i < N; i++){

            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

            if(max - min > mid){
                count++;
                max = arr[i];
                min = arr[i];
            }
        }

        return count <= M;
    }
}