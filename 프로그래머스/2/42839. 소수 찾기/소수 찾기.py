'''
1.아이디어
    - 소수 판별 필요
    1) numbers의 숫자를 한 글자씩 구분하여 한 자리 숫자로 저장 in list
    2) 1~len(list) 개수를 조합하여 만들 수 있는 소수라면, cnt += 1
        이때, 조합을 사용하게 되면 17-71 순서가 없어지므로, 순열(permutations)을 사용한다
    3) 소수를 판별하기 위한 함수 필요
'''
from itertools import permutations

# 소수 판별 함수 
def is_prime(n):
    if n < 2:
        return False
    
    for i in range(2, int(n ** 0.5) + 1):  # √n 까지 검사 + 1 해야 포함됨
        if n % i == 0:
            return False
    return True
    
def solution(numbers):
    
    # 1. numbers를 숫자로 구분하기
    numbers = list(numbers)
    
    # 2. numbers의 있는 숫자들을 1~ len(numebrs) 각각 순열을 구한다
    comb_set = set()
    for i in range(1, len(numbers)+1):
        for comb_item in permutations(numbers,i):
            comb_set.add(int("".join(comb_item)))
        
    return sum([1 for i in comb_set if is_prime(i)])