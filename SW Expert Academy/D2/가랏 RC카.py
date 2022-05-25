
T = int(input())

for testcase in range(1, T+1):
    N = int(input())

    current_speed = 0
    current_distance = 0

    for sec in range(1, N+1):
        data_list = list(map(int, input().split()))

        if len(data_list) == 1 and data_list[0] == 0:
            current_distance += (1 * current_speed)
        else:
            if data_list[0] == 1: # 가속
                current_speed += data_list[1]
            elif data_list[0] == 2: # 감속
                if current_speed <= data_list[1]:
                    current_speed = 0
                else:
                    current_speed -= data_list[1]

            current_distance += (1 * current_speed)

    print("#{} {}".format(testcase, current_distance))