/*
던지는 시간 - 현재 시간
*/

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        
        String[] now = scanner.nextLine().split(":");
        String[] future = scanner.nextLine().split(":");
        int sec=0;
        int min=0;
        int hour=0;
        
        int now_sec = Integer.parseInt(now[2]);
        int future_sec = Integer.parseInt(future[2]);
        int now_min = Integer.parseInt(now[1]);
        int future_min = Integer.parseInt(future[1]);
        int now_hour = Integer.parseInt(now[0]);
        int future_hour = Integer.parseInt(future[0]);
        
        if (now_hour == future_hour &&
            now_min == future_min &&
            now_sec == future_sec) {
            System.out.println("24:00:00");
            return;
        }

        
        if(future_sec >= now_sec){
            sec = future_sec - now_sec;
        }else{
            sec = 60 - now_sec + future_sec;
            future_min--;
        }
        
        
        if(future_min >= now_min){
            min = future_min - now_min;
        }else{
            min = 60 - now_min + future_min;
            future_hour--;
        }
        
        if(future_hour >= now_hour){
            hour = future_hour-now_hour;
        }else{
            if(now_hour == 0){
                hour = future_hour;
            }else{
                hour = 24 - now_hour + future_hour;
            }
        }
               
        answer.append(hour < 10 ? "0"+hour : hour);
        answer.append(":");
        answer.append(min < 10 ? "0"+min : min);
        answer.append(":");
        answer.append(sec < 10 ? "0"+sec : sec);
        
        System.out.println(answer);
        
        
    }
}