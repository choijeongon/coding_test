
T = int(input())

result_map = {}

for index in range(T):
    N = int(input())
    rows = N
    cols = N
    board = [[0 for col in range(cols)] for row in range(rows)]

    # 초기 위치 & 회전방향 설정
    row, column = 0, 0
    # 0:우, 1:하, 2:좌, 3:상
    direction = 0

    # row, col 인덱스로 탐색할 수 있게 방향 설정 
    # (달팽이 방향이니까 우->하->좌->상)
    direction_row = [0, 1, 0, -1]
    direction_column = [1, 0, -1, 0]

    for value in range(1, N*N +1):
        board[row][column] = value
        row += direction_row[direction]
        column += direction_column[direction]

        if row < 0 or column < 0 or row >= N or column >= N or board[row][column] != 0:
            # 실행취소
            row -= direction_row[direction]
            column -= direction_column[direction]

            direction = (direction + 1) % 4

            row += direction_row[direction]
            column += direction_column[direction]

    result_map[N] = board

for index in range(T):
    print("#" + str(index+1))
    
    for value in result_map[index+1]:
        print(*value)