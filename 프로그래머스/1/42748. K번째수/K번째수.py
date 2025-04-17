'''
1. i~j까지 슬라이싱 > k-1번 원소 추출
'''
def solution(array, commands):
    return [sorted(array[i-1:j])[k-1] for i,j,k in commands]
    