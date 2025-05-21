
class Student:
    def __init__(self, korean, english, math):
        self.korean = korean
        self.english = english
        self.math = math

    def get_total(self):
        return self.korean + self.english + self.math

# 입력 예시: 80 90 100
k, e, m = map(int, input().strip().split(","))
student = Student(k, e, m)
print(f"국어, 영어, 수학의 총점: {student.get_total()}")