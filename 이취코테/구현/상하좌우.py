# # 1. 상하좌우
# n = int(input())
# x, y = 1, 1
# plans = input().split()

# dx = [0, 0, -1, 1]
# dy = [-1, 1, 0, 0]
# move_types = ['L', 'R', 'U', 'D']

# # 이동 계획을 하나씩 확인
# for plan in plans:
#     for i in range(len(move_types)):
#         if plan == move_types[i]:
#             nx = x + dx[i]
#             ny = y + dy[i]
#     if nx < 1 or ny < 1 or nx > n or ny > n:
#         continue
#     x, y = nx, ny

# print(x, y)
    

N = int(input())

li = list(input().split())

# 왼, 오, 위, 아
move_col = [0, 0, -1, 1]
move_row = [-1, 1, 0, 0]

action = ['L', 'R', 'U', 'D']

current_col = 1
current_row = 1

for value in li:
    for index in range(len(action)):
        if value == action[index]:
            current_col += move_col[index]
            current_row += move_row[index]

            if current_col < 1 or current_row < 1 or current_col > N or current_row > N:
                current_col -= move_col[index]
                current_row -= move_row[index]

print('{} {}'.format(current_col, current_row))