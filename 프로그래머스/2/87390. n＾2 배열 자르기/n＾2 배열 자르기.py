'''def solution(n, left, right):
    
    # 1. 빈 n*n 배열 생성하기
    n_list = [[0] * n for _ in range(n)]
    #print(n_list)
    
    # 2. i,i 칸에 i 값 입력하기
    for i in range(n):
        for j in range(n):
            if i==j:
                n_list[i][i] = i+1
                #print(n_list)
            else:
                n_list[i][j] = max(i,j)+1
                #print(n_list)
                
    # 3. 가로로 연결
    all_list = []
    for i in n_list:
        all_list.extend(i)
    #print(all_list)
    
    # 4. 결과 출력
    return all_list[left:right+1]
    
    # 시간초과! 모든 배열을 다 만들 필요 없음'''

def solution(n, left, right):
    answer = []
    for k in range(left, right + 1):
        answer.append(max(k // n, k % n) + 1)
    return answer
