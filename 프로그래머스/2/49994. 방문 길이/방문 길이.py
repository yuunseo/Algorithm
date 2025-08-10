'''
<아이디어>
- 처음 걸어본 길의 길이를 구하세요
처음 걸어본 길의 길이를 구하기 위해서는, 해당 길을 지나갔는지 안 지나갔는지 체크해야 함 -> 별도의 그래프 필요?
길을 벗어난 것도 무효처리해야 함

1. 5*5 좌표를 생성한다.
2. (0,0)에서 시작한다.
3. dirs에서 한 idx씩 읽으면서, 좌표에서 지나간 적이 있는지 체크 -> 없다면 cnt ++
->> 이렇게 하면, 좌표로만 저장되어서 갔던 길이 아닌데 다른 경로로 이미 도착했던 좌표도 갔다고 인식해버림. (오류)

<시행착오>
1. (출발,도착) 좌표를 함께 저장하기
2. 모든 좌표 다 구할 필요 없고, 10을 기준으로 10이하로만 저장하자.
'''
def solution(dirs):
    
    # 1. 기본 좌표 초기화
    maps = set()
    x = 5;
    y = 5;
    
    # 2. dirs에서 한 개씩 불러오기
    for item in dirs:
        prev_x, prev_y = x,y
        if(item == "U" and y+1 <= 10): 
            y += 1
        elif(item == "D" and y-1 >= 0):
            y -= 1
        elif(item == "L" and x-1 >= 0):
            x -= 1
        elif(item == "R" and x+1 <= 10):
            x += 1
        
        if (prev_x, prev_y) != (x, y):  # 실제로 이동했을 때만 경로로 인정하기
            path = tuple(sorted([(prev_x, prev_y), (x, y)]))
            maps.add(path)
            
            
    return len(maps)