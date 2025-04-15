'''
1. 아이디어
    - 한 마리 주문 > 쿠폰 1개 > 쿠폰 10개 > 한마리+쿠폰 1개
    - 나머지가 0이 될 때까지 10으로 나눈 몫을 모두 더해준 후, 마지막에 +1 (10마리 주문 시, 1장 주니까!)
    - 
'''
def solution(chicken):
    
    total = 0
    temp = 0
    
    while chicken>=10:
        service = chicken // 10 # 1. 쿠폰 모아서 받을 수 있는 치킨의 개수
        total += service 
        chicken = service + chicken % 10 # 2. 쿠폰으로 인해 받을 수 있는 치킨의 개수 증가 + 나머지 쿠폰 개수
        
    return total