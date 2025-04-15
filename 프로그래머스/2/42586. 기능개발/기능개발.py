'''
1. 아이디어
- 앞에 있는 기능이 먼저 수행 > 뒤에도 가능
    1) 각 작업 별로 남은 기간을 큐에 넣는다
    2) 큐에서 순서대로 꺼내면서,
        다음 순서의 작업이 먼저 끝났다면, count +1
        다음 순서의 작업이 더 늦게 끝난다면, append, new count +1
2. 시간복잡도
- 각 작업별로 남은 기간 구하기: O(N)
- 각 작업을 하나씩 꺼내면서 남은 기간 확인하기: O(N)
3. 변수
- 큐: 작업 순서대로 남은 기간 넣을 자료구조
'''

from collections import deque
import math

def solution(progresses, speeds):
    
    progress_time = deque()
    
    for i in range(len(progresses)):
        partTime = math.ceil((100 - progresses[i]) / speeds[i])
        progress_time.append(partTime)
        
    
    result = []
    
    while len(progress_time) >0 :
        first_prog = progress_time.popleft()
        count = 1
        while progress_time and first_prog >= progress_time[0]:
            progress_time.popleft()
            count += 1
        result.append(count)
        

    return list(result)