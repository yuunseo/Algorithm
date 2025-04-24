'''
1.아이디어
    자신이 원하는 상품 in == 10일 간 세일하는 상품들 > 세일하면 -1개로 갱신 > 존재하면 회원가입 할 거임!
    10일 지났느데, 장바구니에 아직 있으면 안 함
'''

from collections import defaultdict

def solution(want, number, discount):
    answer = 0
    original_cart = dict(zip(want, number))  # 매번 복사할 원본
    
    for start in range(0, len(discount) - 9):
        cart = dict(original_cart)  # 원본을 복사해서 사용
        
        for i in range(10):
            thing = discount[start + i]
            if thing in cart:
                cart[thing] -= 1
        
        # 모든 아이템이 0 이하일 경우, 조건 만족
        if all(value <= 0 for value in cart.values()):
            answer += 1
            
    return answer
