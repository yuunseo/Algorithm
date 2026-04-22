import java.util.*;
class Solution {
    
    /* 차량별 시간을 가지는 객체 */
    class Car{
        String number;
        int hour, min;
        
        Car(String number, String hour, String min){
            this.number=number; 
            this.hour=Integer.parseInt(hour); 
            this.min=Integer.parseInt(min);
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        // 차량 누적 시간 기록
        Map<String, Integer> map = new HashMap<>();
        
        // 차량별 시간 기록
        Map<String, Car> parking = new HashMap<>();
        for(String record: records){
            String[] temp = record.split(" ");
            String[] time_temp = temp[0].split(":");
            String car_number = temp[1];
            String type = temp[2];
            
            Car car = new Car(car_number, time_temp[0], time_temp[1]);
            if(parking.isEmpty()){
                parking.put(car_number, car);
            }else{
                /* 들어간 차가 존재하는지 체크 */
                if(!parking.containsKey(car_number)){
                    parking.put(car_number, car);
                    continue;
                }
                /* 이전에 들어간 차가 존재하면, 시간 계산해서 저장 */
                Car prev_car = parking.get(car_number);
                int hour_diff = car.hour - prev_car.hour;
                int min_diff = car.min - prev_car.min;
                int total_min = 60*hour_diff + min_diff;
                map.put(car.number, map.getOrDefault(car.number,0)+total_min);
                /* 계산 완료 시, 제거 */
                parking.remove(car_number);
            }
        }
        
        /* 모든 차 완료 후, 남은 애들 계산(출차 시간은 23:59) */
        for(Map.Entry<String,Car> entry: parking.entrySet()){
            String cur_number = entry.getKey();
            Car cur = entry.getValue();
            int hour_diff = 23 - cur.hour;
            int min_diff = 59 - cur.min;
            int total_min = 60*hour_diff + min_diff;
            map.put(cur_number, map.getOrDefault(cur_number,0)+total_min);
        }
        
        /* 차 누적 시간별 요금 계산 */
        List<String> cars = new ArrayList<>(map.keySet());
        Collections.sort(cars);  // 차량 번호 기준 정렬

        int[] answer = new int[cars.size()];
        int idx = 0;

        for(String car_number : cars){
            int total_time = map.get(car_number);

            int fee;
            if(total_time <= fees[0]){
                fee = fees[1];
            }else{
                fee = fees[1] + 
                      (int)Math.ceil((total_time - fees[0]) / (double)fees[2]) * fees[3];
            }

            answer[idx++] = fee;
        }
        
        return answer;
        
    }
}