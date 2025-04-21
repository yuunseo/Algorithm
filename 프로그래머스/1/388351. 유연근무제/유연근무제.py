def solution(schedules, timelogs, startday):
    
    # 시작-종료 시간 계산하기
    end_schedules = []
    for t in schedules:
        s_hour = t//100
        s_min = t%100
        e_hour = s_hour + (s_min+10)//60
        e_min = (s_min+10)%60
        e_time = e_hour*100 + e_min
        end_schedules.append(e_time)
        
    #print(end_schedules)
        
    # 직원별 시간 체크하기 
    check_list = [[0 for j in range(8)] for i in range(len(schedules))] # 직원별로 7일치 스케줄 배열 초기화
    
    total_players = len(schedules)
    for idx,player in enumerate(timelogs):
        for day, time in enumerate(player):
            if time <= end_schedules[idx]: # and 최대 시간 이전인 경우!
                check_list[idx][(day+startday)%7] = 1
            else:
                continue
                

    cnt = 0
    for i in check_list:
        if sum(i[1:6]) == 5: cnt += 1
    
    return cnt