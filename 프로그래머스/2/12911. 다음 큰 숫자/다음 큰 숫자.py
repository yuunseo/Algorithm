def solution(n):
    
    bin_list = []
    bin_list.append(bin(n)[2:])
    idx = 1
    
    while 1:
        # 조건 1. 자연수이다
        # 조건 2. 2진수 변환 시, 1의 갯수가 같다
        # 조건 3. 1+2번을 만족하는 동시에 가장 작은 수
        bin_list.append(bin(n+idx)[2:])
    
        if bin_list[0].count('1') == bin_list[1].count('1'):
            break
        else:
            idx += 1
        del bin_list[-1]
        
    return n+idx