from math import gcd

def solution(a, b):
    
    b //= gcd(a,b) # 1. 나누어질 때까지 최대로 나누기
    
    while b%2==0: # 2. 소인수가 2 그리고 5만 존재해야 하므로, 2와 5로 끝까지 나누기
        b//=2
        
    while b%5==0:
        b//=5
    
    return 1 if b==1 else 2 # 3. 그 결과가 1일 경우, 1 - 2이 아니라면 그 외에 소인수가 존재하므로 2를 반환