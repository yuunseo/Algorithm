def solution(numbers):
    
    numbers = list(map(str, numbers))  # 문자열로 변환
    numbers.sort(key=lambda x: x*3, reverse=True)  # 핵심! 문자열을 3번 반복해서 정렬 기준으로 사용
    # 3번 반복한 문자열로 정렬하는 이유는, 비교 가능한 자릿수 1000이하로 만들어주어서 비교하면 된다.
    # 현재는 3 vs 34라고 했을 때 
    # 1000자리수에서 비교하기 위하여,
    # 333 vs 343434 -> 343이 더 큼!
    return '0' if numbers[0] == '0' else ''.join(numbers)
