'''
1. 아이디어
    - 한 장씩 뽑고 다시 사용할 수 없는 걸 보아 queue 활용 가능성
    - goal에서 하나씩 가져와서, cards1, cards2에 있으면 제거
        - goal이 없어지기 전에 queue가 먼저 없어지거나, 꺼낸 것과 다르다면 "NO"
2. 변수
- queue: cards1, cards2, goal
'''

from collections import deque

def solution(cards1, cards2, goal):
    
    cards1 = deque(cards1)
    cards2 = deque(cards2)
    goal = deque(goal)
    
    while goal:
        
        item = goal.popleft()
        if cards1 and item == cards1[0]:
            cards1.popleft()
        elif cards2 and item == cards2[0]:
            cards2.popleft()
        else:
            return "No"
    return "Yes"
    