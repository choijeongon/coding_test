# length, count, continuous_limit = map(int, input().split())

# data = list(map(int, input().split()))

# print("length: " + str(length))
# print("count: " + str(count))
# print("continuous_limit: " + str(continuous_limit))
# print(data)

# max_value = 0
# result = 0
# saved_continuous_limit = continuous_limit

# data.sort(reverse=True)
# second_value = data[1]
# # print(data)
# # print(data[1])

# for value in data:
#     max_value = max(max_value, value)

# # print(str(max_value))

# while count > 0:
#     if(continuous_limit == 0):
#         result += second_value
#         continuous_limit = saved_continuous_limit
#         count -= 1
#         continue
#     result += max_value
#     count -= 1
#     continuous_limit -= 1

# print("result: " + str(result))

# # 정답 코드
# n, m, k = map(int, input().split())
# data = list(map(int, input().split()))

# data.sort()
# first = data[n-1]
# second = data[n-2]

# result = 0

# while True:
#     for i in range(k): # 가장 큰 수를 K번 더하기
#         if m == 0:
#             break
#         result += first
#         m -= 1 # 더할 때마다 1씩 빼기
#     if m == 0:
#         break
#     result += second
#     m -= 1

# print(result)


N, M, K = map(int, input().split())

data_list = list(map(int, input().split()))

data_list.sort()

max_value = data_list[-1]
sub_max_value = data_list[-2]

result = 0
count = K

for i in range(M):
    if count == 0:
        result += sub_max_value
        count = K
        continue

    result += max_value
    count -= 1

print(result)
    