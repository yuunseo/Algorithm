'''
1. 아이디어
- stack에 넣기: 2가 나오면 넣기 시작 & 다시 2가 나오면 하나의 리스트로 만들어두기
    -> 이렇게 하면, 2가 여러 개인 경우를 알기 어렵군.
- index 저장해 두기: 2가 나올 때, 인덱스를 저장해 두기
    -> 인덱스가 0개라면, -1 반환
    -> 인덱스가 여러 개라면, 맨 앞과 뒤 인덱스로 리스트 만들어서 반환
2. 시간복잡도
- O(N): 모든 원소 확인해야 하니까
3. 변수
- index를 저장해 둘 리스트: int[]
'''

def solution(arr):

    index_list = [idx for idx,item in enumerate(arr) if item==2]
    
    return arr[index_list[0]:index_list[-1]+1] if len(index_list)!=0 else [-1]
    