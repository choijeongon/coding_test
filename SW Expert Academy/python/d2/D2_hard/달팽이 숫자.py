
#1
# T = int(input())

# result_map = {}

# for index in range(T):
#     N = int(input())
#     rows = N
#     cols = N
#     board = [[0 for col in range(cols)] for row in range(rows)]

#     # 초기 위치 & 회전방향 설정
#     row, column = 0, 0
#     # 0:우, 1:하, 2:좌, 3:상
#     direction = 0

#     # row, col 인덱스로 탐색할 수 있게 방향 설정 
#     # (달팽이 방향이니까 우->하->좌->상)
#     direction_row = [0, 1, 0, -1]
#     direction_column = [1, 0, -1, 0]

#     for value in range(1, N*N +1):
#         board[row][column] = value
#         row += direction_row[direction]
#         column += direction_column[direction]

#         if row < 0 or column < 0 or row >= N or column >= N or board[row][column] != 0:
#             # 실행취소
#             row -= direction_row[direction]
#             column -= direction_column[direction]

#             direction = (direction + 1) % 4

#             row += direction_row[direction]
#             column += direction_column[direction]

#     result_map[N] = board

# for index in range(T):
#     print("#" + str(index+1))
    
#     for value in result_map[index+1]:
#         print(*value)

#2
# T = int(input())

# result_map = {}

# direction_column = [0, 1, 0, -1]
# direction_row = [1, 0, -1, 0]

# for i in range(T):
#     N = int(input())

#     board = [[0 for col in range(N)] for ro in range(N)]

#     column = 0
#     row = 0

#     # 우, 하, 좌, 상 순
#     direction = 0

#     for value in range(1, N*N +1):
#         board[column][row] = value
#         column += direction_column[direction]
#         row += direction_row[direction]

#         if column < 0 or row < 0 or column >= N or row >= N or board[column][row] != 0:
#             column -= direction_column[direction]
#             row -= direction_row[direction]

#             direction = (direction + 1) % 4

#             column += direction_column[direction]
#             row += direction_row[direction]

#     result_map[N] = board

# for i in range(T):
#     print("#" + str(i+1))
#     for val in result_map[i+1]:
#         print(*val)

#3
# 오, 아, 왼, 위
direct_x = [0, 1, 0, -1]
direct_y = [1, 0, -1, 0]

T = int(input())

for testcase in range(1, T+1):
    testcase_number = int(input())

    board = [[0] * testcase_number for _ in range(testcase_number)]

    direct = 0

    current_x = 0
    current_y = 0

    for value in range(1, testcase_number*testcase_number +1):
        board[current_x][current_y] = value
        current_x += direct_x[direct]
        current_y += direct_y[direct]

        if current_x >= testcase_number or current_y >= testcase_number or board[current_x][current_y] != 0:
            current_x -= direct_x[direct]
            current_y -= direct_y[direct]

            direct = (direct+1) % 4

            current_x += direct_x[direct]
            current_y += direct_y[direct]

    print("#" + str(testcase))
    for index in range(testcase_number):
        print(*board[index], end = ' ')
        print()




