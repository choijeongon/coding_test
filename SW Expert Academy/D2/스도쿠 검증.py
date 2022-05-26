# def check_right():
#     for i in range(9):
#         right = []
#         for j in range(9):
#             if sdk[i][j] in right:
#                 return 0
#             else:
#                 right.append(sdk[i][j])
#     return 1


# def check_down():
#     for i in range(9):
#         down = []
#         for j in range(9):
#             if sdk[j][i] in down:
#                 return 0
#             else:
#                 down.append(sdk[j][i])
#     return 1

# # check_squre코드는 잘못짰는데 pass됐음
# def check_square(y, x):
#     square = []
#     if y+3 > 9 or x+3 > 9:
#         return 1
#     for i in range(y, y+3):
#         for j in range(x, x+3):
#             if sdk[i][j] in square:
#                 return 0
#             else:
#                 square.append(sdk[i][j])
    
#     return check_square(y+3, x+3)

# T = int(input())
# for test_case in range(1, T+1):
#     sdk = [list(map(int, input().split())) for _ in range(9)]

#     if check_square(0, 0) == 0 \
#             or check_right() == 0 \
#             or check_down() == 0:
#         print(f'#{test_case} 0')
#     else:
#         print(f'#{test_case} 1')



def check_list(row_list):
    number_list = [1, 2, 3, 4, 5, 6, 7, 8, 9]

    for val in row_list:
        if val in number_list:
            number_list.remove(val)

    if not number_list:
        return True # 중복 값이 없음
    else:
        return False

T = int(input())

for testcase in range(1, T+1):

    data_list = [list(map(int, input().split())) for _ in range(9)]

    reversed_list = [[0] * 9 for _ in range(9)]

    confrim_list = []

    for i in range(9):
        for j in range(9):
            reversed_list[j][9-1-i] = data_list[i][j]

    # 가로행 검사
    for index in range(9):
        confrim_list.append(check_list(data_list[index]))

    # 새로행 검사
    for index in range(9):
        confrim_list.append(check_list(reversed_list[index]))

    # 3*3 검사
    for i in range(0, 7, 3):
        for j in range(0, 7, 3):
            temp_list = []

            for a in range(3):
                for s in range(3):
                    temp_list.append(data_list[i+a][j+s])

            confrim_list.append(check_list(temp_list))

    if False in confrim_list:
        print("#{} {}".format(testcase, 0))
    else:
        print("#{} {}".format(testcase, 1))
