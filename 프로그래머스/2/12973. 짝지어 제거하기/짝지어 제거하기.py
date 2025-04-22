'''
아이디어1. 문자열에서 인덱스로 접근 > 인덱스 초과 에러
아이디어2. 스택 이용
'''

def solution(s):

    stack = []

    for i in s:
        if stack:
            if i == stack[-1]:
                stack.pop()
                continue
            else:
                stack.append(i)
        else:
             stack.append(i)   

    return 0 if stack else 1