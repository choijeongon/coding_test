

def solution(n, lost, reserve):
    answer = 0
    student_list = [1] * n
    # 여분 채워넣기
    for i in reserve:
        student_list[i-1] += 1
    print("여분")
    print(student_list)

    #도둑 맞기
    for index in lost:
        student_list[index-1] -= 1
    print("도둑 맞기")
    print(student_list)

    #친구 찾기
    for index in range(len(student_list)):
        # 만약 현재 인덱스가 체육복이 없다면
        if student_list[index] == 0:
            if (index -1) != -1:
                if student_list[index -1] > 1:
                    student_list[index -1] -= 1
                    student_list[index] += 1
                    continue
            if (index +1) != len(student_list):
                if student_list[index +1] > 1:
                    student_list[index +1] -= 1
                    student_list[index] += 1
                    continue
    print("친구 찾기")
    print(student_list)

    for value in student_list:
        if value >= 1:
            answer += 1

    return answer

