def solution(numbers):
    
    numbers = list(map(str, numbers))  # 문자열로 변환
    numbers.sort(key=lambda x: x*3, reverse=True)  # 핵심! 문자열을 3번 반복해서 정렬 기준으로 사용
    return '0' if numbers[0] == '0' else ''.join(numbers)
