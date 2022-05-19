N, K = map(int, input().split())

list_A = list(map(int, input().split()))
list_B = list(map(int, input().split()))

for i in range(K):
    a_min_value = min(list_A)
    b_max_value = max(list_B)

    if a_min_value < b_max_value:
        a_min_index = list_A.index(a_min_value)
        b_max_index = list_B.index(b_max_value)

        list_A[a_min_index], list_B[b_max_index] = list_B[b_max_index], list_A[a_min_index]

result = 0

for value in list_A:
    result += value

print(result)