T= int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    save = []
    if N < M:
        for i in range(abs(M-N)+1):
            add = 0
            for j in range(len(A)):
                add += A[j]*B[j]
            save.append(add)
            A.insert(0, 0)
    elif N > M:
        for i in range(abs(M-N)+1):
            add = 0
            for j in range(len(B)):
                add += A[j]*B[j]
            save.append(add)
            B.insert(0, 0)
    print(f'#{test_case} {max(save)}')