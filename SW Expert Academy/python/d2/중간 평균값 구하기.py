
T = int(input())

for index in range(1, T+1):
    li = list(map(int, input().split()))

    max_value = max(li)
    min_value = min(li)

    li.remove(max_value)
    li.remove(min_value)

    total_value = 0

    for value in li:
        total_value += value
    
    result = total_value / len(li)
    print('#{} {}'.format(index, round(result)))