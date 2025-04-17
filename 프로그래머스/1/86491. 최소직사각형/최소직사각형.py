'''
1. 아이디어
    - 모든 명함을 넣을 수 있어야는데 그 중 가장 작은 지갑 크기 만들기
    - 회전이 가능하므로, 가로세로 정렬 후에 최대 작은 지갑 사이즈 찾자
    1) 가로끼리 모아서 list, 세로끼리 모아서 list -> 가로 중 가장 긴 거 * 세로 중 가장 긴 거
2. 시간복잡도 
    - O(N*2lgN): for loop 안에서 sort 발생
'''
def solution(sizes):
    
    # 가로, 세로를 나누어서 저장하기 - 모두 가로로 긴 직사각형으로 통합
    
    width_sizes = [max(size) for size in sizes]
    length_sizes = [min(size) for size in sizes]
    
    return max(width_sizes) * max(length_sizes)