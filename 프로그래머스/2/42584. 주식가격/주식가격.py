'''
1. 아이디어
- 가격이 떨어진 것을 표현하기 위해서는, 다음 시점들 중 나보다 작은 가격일 때의 시점의 개수를 구하면 됨
- prices를 하나씩 가져온 후,
    그 뒤에 남은 인덱스랑 비교 >> 시간초과 및 실패
- 하나의 스택을 만들고, 해당 스택에서는 가격 떨어진 결과 계산
    i를 넣고, 보다 큰 가격일 경우 해당 인덱스를 스택에 추가
    i보다 작은 가격일 경우, 이전 인덱스를 뽑아서 현재 인덱스와의 차이를 결과로 추가
'''
from collections import deque

def solution(prices):
    
    answer = [0] * len(prices) # 결과를 담을 list
    stack = [] # 가격이 떨어지지 않은 기간을 담을 stack
    
    for idx, price in enumerate(prices):
        while stack and prices[stack[-1]] > price: # 이전 값이랑 다음 값이랑 비교 -> 다음 값이 작아진다면 stop
            j = stack.pop()
            answer[j] = idx-j
        stack.append(idx)
            
    for i in stack:
        answer[i] = len(prices) - 1 - i
    
    return answer