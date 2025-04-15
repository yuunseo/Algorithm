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
    idx = 0
    
    # 1-1. 첫 괄호가 닫힘이라면 False 열림이라면 계속 진행 -> 이렇게 처리해 버리면, 반복문으로 뒤에서 처리 불가능! 
    '''if s[idx] == ")":
        return False
    elif s[idx] == "(":
        stack.append(s[idx])
        idx += 1'''
        
    # 2. 스택에서 한 쌍의 괄호 찾기 
    while idx < len(s):
        if s[idx] == ")" and stack[-1:] == ["("]: # 열림-닫힘 쌍이 맞을 때,
            stack.pop()
        else:
            stack.append(s[idx])
        idx += 1
        
    # 3. 스택이 비어있지 않으면 False 비어있다면 True
    return False if stack else True