/*
필요한 값: 보유 현금, 주가, 보유 주식의 개수
준현
- if(보유 현금 >= 주가){ 보유 주식의 개수 = 보유 현금//주가, 보유 현금 = 보유현금%주가}
성민
- if(보유 현금 >= 주가){ 보유 주식의 개수 = 보유 현금//주가, 보유 현금 = 보유현금%주가}
- 연속 카운드 count_up == 3라면, {보유 현금 += 보유 주식의 개수*주가, 보유 주식의 개수 = 0}
- 연속 카운드 count_down == 3라면, {보유 주식의 개수 = 보유 현금//주가, 보유 현금 = 보유현금%주가}
- 전 날에 비해 상승했다면, count_down=0, 하락했다면 count_up=0 (연속이 깨지니까!)
*/
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int yes = -1;
        int count_up = 0;
        int count_down = 0;
        
        // 준현이
        int money_jun = money;
        int stock_jun = 0;
        // 성민이
        int money_sung = money;
        int stock_sung = 0;
        
        while(st.hasMoreTokens()){
            int price = Integer.parseInt(st.nextToken());
      
            // 준현
            if(money_jun >= price){
                stock_jun += money_jun/price;
                money_jun = money_jun%price;
            }
           
                  
            // 전날과 비교
            if(yes!=-1 && yes<price){
                count_up ++;
                count_down=0;
            }else if(yes!=-1 && yes>price){
                count_down ++;
                count_up=0;
            }
            
            yes = price;
            
            // 성민
            if(count_up == 3){
                // 전량 매도
                money_sung += stock_sung*price;
                stock_sung = 0;
            }else if(count_down == 3){
                // 전량 매수
                stock_sung += money_sung/price;
                money_sung = money_sung%price;
            }
            
        }
        int total_jun = money_jun + (yes * stock_jun);
        int toal_sung = money_sung + (yes * stock_sung);
        
        if(total_jun > toal_sung){
            System.out.println("BNP");
        }else if(total_jun < toal_sung){
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }
            
    }
}