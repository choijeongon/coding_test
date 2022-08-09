
#1
# # t = input()

# # count = 1

# # dic = {}

# # for index in range(int(t)):
# #     data = list(map(int, input().split()))
# #     result = 0

# #     for i in range(len(data)):
# #         result = max(result, data[i])

# #     dic[index+1] = result


# # while count <= int(t):
# #     print('#' + str(count) + " " + str(dic[count]))
# #     count += 1

#2
# T = int(input())

# result_map = {}

# for i in range(T):
#     data = list(map(int, input().split()))
#     result = 0

#     for val in data:
#         result = max(result, val)
    
#     result_map[i+1] = result

# for i in range(T):
#     print("#" + str(i+1) + " " + str(result_map[i+1]))

#3
T = int(input())

for testcase in range(1, T+1):
    data_list = list(map(int, input().split()))

    max_value = 0

    for value in data_list:
        max_value = max(max_value, value)
    
    print("#{} {}".format(testcase, max_value))