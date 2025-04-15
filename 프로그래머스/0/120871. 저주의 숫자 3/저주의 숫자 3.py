
def solution(n):
    idx = 0  # 실제 숫자
    chk = 0  # 3x 마을에서 셌을 때의 숫자
    
    while chk < n:
        idx += 1
        if idx % 3 != 0 and '3' not in str(idx):
            chk += 1
            
    return idx