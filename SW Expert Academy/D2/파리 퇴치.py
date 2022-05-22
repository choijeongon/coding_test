
T = int(input())

result_map = {}

for index in range(1, T+1):
    N, M = map(int, input().split())
    arr = []
    for i in range(N):
        temp = list(map(int, input().split()))
        arr.append(temp)
    
    n = M-1
    max_v = 0

    for i in range(N-n):
        for j in range(N-n):
            sum_v = 0

            for di in range(M):
                for dj in range(M):
                    sum_v += arr[i+di][j+dj]
            
            if sum_v > max_v:
                max_v = sum_v
    
    result_map[index] = max_v

for index in range(1, T+1):
    print("#" + str(index) +" " +str(result_map[index]))


# 민수형 풀이
# def kill_fly(y:int, x:int, M:int)->int:
#     sum = 0
#     for i in range(y, y+M):
#         for j in range(x, x+M):
#             sum += area[i][j]
#     return sum

# T = int(input())
# for test_case in range(1, T+1):
#     N, M = map(int, input().split())
#     area = [list(map(int, input().split())) for _ in range(N)]
#     store = []
#     for i in range(abs(M-N)+1):
#         for j in range(abs(M-N)+1):
#             store.append(kill_fly(i, j, M))
#     print(f'#{test_case} {max(store)}')
