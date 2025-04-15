'''
1. 아이디어
- priorities를 큐로 변경
    1) popleft를 통해 우선순위 확인
    1-1) 더 큰 수가 큐에 존재한다면, append()
        > 더 큰 수가 뒤에 존재하는지 확인을 위해 cnt 변수 설정
        > 더 큰 수가 있다면 cnt++ 없다면 0
            - 0이면, 내가 젤 큰 수니까 실행
            - 1이상이면, 뒤에 큰 수가 있으니까 맨 뒤로
        
2. 시간복잡도
- O(N): 우선 하나씩 꺼내와야 하니까
- O(1): deque를 통해 앞/뒤로 수정하니까
- O(N^2): 큐의 원소를 꺼내서, 뒤에 최대 값 확인해야 하니까
3. 변수
- deque 2개: 실행한 작업/기존 작업
'''
from collections import deque

def solution(priorities, location):
        
    result = deque()
    que = deque([(i,v) for i,v in enumerate(priorities)])
            
    while que:
        item = que.popleft()
        
        cnt = 0
        for j,i in que:
            if item[1] < i:
                cnt += 1
                
        if cnt >= 1:
            que.append(item)
        else:
            result.append(item)
                        
    for idx, item in enumerate(result):
        if item[0] == location:
            return idx+1