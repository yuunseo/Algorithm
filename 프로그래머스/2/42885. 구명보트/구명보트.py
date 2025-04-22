def solution(people, limit):
    
    # 1) list에서 비교하면서 list를 갱신하면, 계속해서 업데이트 됨에 따라 시간복잡도 높아짐!
    # 2) 투포인터 방법으로 진행!
    
    people.sort()
    
    i, j = 0, len(people) - 1 # i는 가벼운 사람 j는 무거운 사람
    answer = 0

    while i <= j:
        if people[i] + people[j] <= limit:
            i += 1  # 가벼운 사람 태움
        j -= 1      # 무거운 사람 태움 (항상 태움)
        answer += 1

    return answer
