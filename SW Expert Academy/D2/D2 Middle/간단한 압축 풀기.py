from collections import deque

T = int(input())

for tc in range(1, T+1):
    N = int(input())

    queue = deque()

    for _ in range(N):
        ci, ki = input().split()

        for _ in range(int(ki)):
            queue.append(ci)
    
    answer = ''

    print("#"+ str(tc))
    
    while queue:
        answer += queue.popleft()

        if len(answer) == 10:
            print(answer)
            answer = ''
    print(answer)