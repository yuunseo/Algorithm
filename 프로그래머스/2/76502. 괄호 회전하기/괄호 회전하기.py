'''
1.아이디어
    스택으로 넣어서 짝이 맞으면 제거 한 쌍의 괄호 찾으면 cnt += 1
    괄호를 하나하나 [,] if 문으로 나눠야 하나?
    딕셔너리로 처리할 수 있을까?
'''

def solution(s):
    
    str_dict = {']':'[',')':'(','}':'{'}
    extend = s*2    
    cnt = 0

    s_len = len(s)
    
    # s번 확인했을 때
    for i in range(0,s_len): # 0~5까지
        if i == 0:
            string = extend[-s_len-i:]
        else:
            string = extend[-s_len-i:-i]
        stack = []
        
        for i in string:
            if stack and i in str_dict:

                if stack[-1] == str_dict[i]:
                    stack.pop()
                else:
                    break
            else:
                stack.append(i)

        if not stack: cnt += 1
        
    return cnt