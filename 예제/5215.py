import collections
 
 
T = int(input())
 
 
for test_case in range(1, T + 1):
    N, L = map(int, input().split())  # N: 갯수, L: 칼로리제한
    pack = []
    hamburger = collections.defaultdict(list)  # 가치, 부피
    for i in range(N):
        T, K = map(int, input().split())  # 맛점수, 칼로리
        hamburger[i] = (T, K)  # 맛점수, 칼로리
    for i in range(N+1):
        pack.append([])
        for j in range(L+1):
            if i == 0 or j == 0:
                pack[i].append(0)
            elif hamburger[i-1][1] <= j:
                pack[i].append(
                    max(hamburger[i-1][0] + pack[i-1][j-hamburger[i-1][1]],
                        pack[i-1][j]))
            else:
                pack[i].append(pack[i-1][j])
    print(f'#{test_case} {pack[-1][-1]}')
 
 