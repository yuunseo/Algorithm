/*
명령어 수행 결과를 출력하세요
*/
import java.util.*;
import java.io.*;

class Main{
    static int[] lights;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lights = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<lights.length; i++){
            lights[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<M; i++){
            changeLights(new StringTokenizer(br.readLine()));
        }
        
        for(int i=0; i<N; i++){
            System.out.print(lights[i]+" ");
        }
        
        
    }
    
    private static void changeLights(StringTokenizer st){
        int n = Integer.parseInt(st.nextToken());
        
        switch(n){
            case 1:
                    {int i = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    lights[i-1] = x;
                    break;}
                
            case 2:
                    {int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    for(int i=l-1; i<r; i++){
                        lights[i] = (lights[i]==1) ? 0 : 1;
                    }
                    break;}
            case 3:
                    {int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    for(int i=l-1; i<r; i++){
                        lights[i] = 0;
                    }
                    break;}
            case 4:
                    {int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    for(int i=l-1; i<r; i++){
                        lights[i] = 1;
                    }
                    break;}
        }
    }
}