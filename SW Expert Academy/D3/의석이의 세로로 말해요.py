
T = int(input())

for tc in range(1, T+1):
    answer = ''

    data_list = [[0] * 15 for _ in range(5)]

    for i in range(5):
        data_list[i] = input()

    for i in range(15):
        for j in range(5):
            try:
                answer += data_list[j][i]
            except:
                answer += ''
    
    print("#{} {}".format(tc, answer))