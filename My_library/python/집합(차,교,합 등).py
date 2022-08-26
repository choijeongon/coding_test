T = int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    N_list = input().split()
    M_list = input().split()
    N_set, M_set = set(), set()
    for n in N_list:
        N_set.add(n)
    N_set = set(N_set)
    for m in M_list:
        M_set.add(m)
    M_set = set(M_set)
 
    N_set = N_set & M_set
    print(f'#{test_case} {len(N_set)}')
 
'''입력
2
2 3
ab a
a ac ba
3 3
aa bb cc
dd cc aa
'''
 
'''출력
#1 1
#2 2
'''
 
'''
교집합
set1 & set2
 
합집합
set1 | set2
 
차집합
set1 - set2
 
대칭차집합
set1 ^ set2
 
집합 추가
set.update([7,8,9])
집합 제거
set.remove(9)
'''
