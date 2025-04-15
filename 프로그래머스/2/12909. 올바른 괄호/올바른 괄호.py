'''
1. 아이디어
- 열린괄호와 닫힌괄호를 한 쌍으로 -> 만나면 pop
    1) 모두 list에 넣어두고 하나씩 꺼내기
    2) 하나씩 넣으면서 들어있는 거랑 비교하기
- s를 모두 접근했을 때, 스택에 남아있다면 False 없으면 True
2. 시간복잡도
- s를 모두 접근해야 하니까 O(N)
3. 변수
- 스택 list[]
'''

def solution(s):
    
    # 1. 스택 초기화
    stack = []
    
    # 2. 괄호 스택에 추가
    for char in s:
        if char == "(":
            stack.append(char)
        else:  # char == ")"
            if not stack:
                return False
            stack.pop()
            
    return not stack