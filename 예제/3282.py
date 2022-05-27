import collections
 
 
T = int(input())
 
for test_case in range(1, T + 1):
    pack = []
    cargo = collections.defaultdict(list)
    n, k = map(int, input().split())  # 물건 개수, 가방 부피
    max_cost = 0
    for i in range(n):
        v, c = map(int, input().split())  # 부피, 가치
        cargo[i] = (c, v)  # 가치, 부피
 
    for i in range(n + 1):
        pack.append([]) # 팩
        for g in range(k+1):
            if i == 0 or g == 0:
                pack[i].append(0) # 팩
            elif cargo[i-1][1] <= g: # 카
                pack[i].append(max(cargo[i-1][0] + pack[i-1]
                               [g-cargo[i-1][1]], pack[i-1][g]))  # 팩카팩카팩
            else:
                pack[i].append(pack[i-1][g]) # 팩팩
    print(f'#{test_case} {pack[-1][-1]}')