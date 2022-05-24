def check_right():
    for i in range(9):
        right = []
        for j in range(9):
            if sdk[i][j] in right:
                return 0
            else:
                right.append(sdk[i][j])
    return 1


def check_down():
    for i in range(9):
        down = []
        for j in range(9):
            if sdk[j][i] in down:
                return 0
            else:
                down.append(sdk[j][i])
    return 1

# check_squre코드는 잘못짰는데 pass됐음
def check_square(y, x):
    square = []
    if y+3 > 9 or x+3 > 9:
        return 1
    for i in range(y, y+3):
        for j in range(x, x+3):
            if sdk[i][j] in square:
                return 0
            else:
                square.append(sdk[i][j])
    
    return check_square(y+3, x+3)

T = int(input())
for test_case in range(1, T+1):
    sdk = [list(map(int, input().split())) for _ in range(9)]

    if check_square(0, 0) == 0 \
            or check_right() == 0 \
            or check_down() == 0:
        print(f'#{test_case} 0')
    else:
        print(f'#{test_case} 1')