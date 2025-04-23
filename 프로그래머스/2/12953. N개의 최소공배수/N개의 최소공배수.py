'''
1. 아이디어
    최소 공배수란 > 두 수의 곱을 최대 공약수로 나눈 값!
    여러 수의 최소 공배수를 구하기 위해선, 여러 수를 만족하는 최대 공약수를 구하자!
    여러 수의 최대 공약수 == 1, -> 그냥 나누기
    != 1, -> 수의 개수만큼 더 나누기
'''

def gcd(a,b):
    while b!=0:
        a,b = b,a%b
    return a

def lcm(a,b):
    return (a*b)//gcd(a,b)

def solution(arr):
    
    ini = lcm(arr[0],arr[1])
    idx = 2
    while idx<len(arr):
        ini = lcm(ini, arr[idx])
        idx += 1
        
    return ini
        