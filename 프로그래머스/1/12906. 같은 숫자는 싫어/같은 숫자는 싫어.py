'''
1. 아이디어
- 연속적으로 나타나는 숫자는 하나만 남기고, 전부 제거한다 (중복제거&순서유지)
- 스택에 하나씩 넣되, 이전에 넣은 수와 같은 수라면 pass
2. 시간복잡도
- O(N) 하나씩 원소를 확인하며 넣어야 한다
3. 변수
- int[]: stack 기능을 구현할 정수 리스트
'''

def solution(arr):
    stack = []
    
    for i in arr:
        if stack and stack[-1] == i:
            continue
        else:
            stack.append(i)
        
    return stack
        