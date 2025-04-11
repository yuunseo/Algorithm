'''
1. 아이디어
- 공식을 이용하여 계산
'''
import math

def solution(balls, share):
    result = math.factorial(balls) / math.factorial(balls-share) /math.factorial(share)
    return result