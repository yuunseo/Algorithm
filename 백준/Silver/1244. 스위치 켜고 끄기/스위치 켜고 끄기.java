/*
남: 본인의 수 포함, 배수<=8 스위치 반대로 변경
여: 본인의 수 포함, 양 옆 i-1, i+1 스위치의 상태가 같으면 i++, 상태 다를 때까지
상태를 바꾸기 위해서는 기존 상태를 기억하고 있을 수 있는 자료구조가 필요함: 2차원 배열?
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        boolean[] switchs = new boolean[N+1];
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            switchs[i] = st.nextToken().equals("1") ? true : false ;
        }
        
        int stud = Integer.parseInt(br.readLine());
        for(int i=0; i<stud; i++){
            st= new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if(gender==1){
                for(int j=1; j<=N; j++){
                    if(j%num==0){
                        switchs[j] = !switchs[j];
                    }
                }
            }else{
                int left = num;
                int right = num;
                while(1<=left-1 && right+1<=N && switchs[left-1] == switchs[right+1]){
                    left--; right++;
                }
                
                for(int j=left; j<=right; j++){
                    switchs[j] = !switchs[j];
                }
                
            }
        }
        
        for(int i=1; i<=N; i++){
            if(switchs[i]){
                System.out.print("1");
            }else{
                System.out.print("0");
            }
            
            if(i%20==0){
                System.out.print("\n");
            }else{
                System.out.print(" ");
            }
        }
    }
}