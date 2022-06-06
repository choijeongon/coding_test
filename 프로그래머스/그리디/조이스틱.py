# 앞 커서가 빠른지 뒤 커서가 빠른지 비교
# 앞으로 탐색하는게 빠른지 뒤로 탐색하는게 빠른지 비고

def solution(name):
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    # start_name = 'A' * len(name)
    answer = 0

    for value in name:
        count = 0
        reversed_count = 1
        if value == 'A':
            answer -= 1
        # 앞에서부터 탐색
        for index in range(len(alphabet)):
            print(alphabet[index], end= '')
            if alphabet[index] == value:
                break
            count += 1
        print()
        #뒤에서부터 탐색
        for index in range(len(alphabet)-1, -1, -1):
            print(alphabet[index], end= '')
            if alphabet[index] == value:
                break
            reversed_count += 1

        print()
        print("count= " + str(count))
        print("reversed_count= " + str(reversed_count))
        print("next value")
        answer += 1
        if count > reversed_count:
            answer += reversed_count
        else:
            answer += count

    return answer-1

print(solution("AAAA"))
