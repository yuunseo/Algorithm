def solution(n):
    # n --> 1이 될 때까지 나머지가 1인 경우만 count 해주기
    # 이 말은 즉, 2진수로 바꾸었을 때, 1의 개수와 동일함
    
    return bin(n).count('1')

'''


# 1. 순간이동으로 갈 수 있는 최장거리
    a = n // 2
    b = n % 2 # k칸 점프해야 하는 거리
    
    # 2. a까지 이동하기 위한 순간이동 + 점프
    while 1:
        
        if a//2 == 1:
            b += a//2
            b += a % 2
            break
        else:
            b += a % 2
            a //= 2
            
    return b
    
    ## 2번째 시도. 시간초과
    answer = 0
    
    while n//2 != 1:
        answer += (n%2)
        n //= 2
        
    return answer + (n%2) +1
    
    
    '''