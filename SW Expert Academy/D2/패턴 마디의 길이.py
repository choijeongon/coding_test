#1
# T = int(input())

# result_map = {}

# for index in range(1, T+1):
#     data = input()

#     mady = ''

#     for i in range(1, len(data) + 1):
#         if data[:i] == data[i:i*2]:
#             mady = data[:i]
#             break

#     result_map[index] = len(mady)

# for index in range(1, T+1):
#     print("#" + str(index) + " " + str(result_map[index]))

#2
T = int(input())

for testcase in range(1, T+1):
    input_data = input()

    result = ''

    for index in range(1, 31):
        a = input_data[:index]
        b = input_data[index:index+len(a)]

        if a == b:
            result = a
            break

    print("#{} {}".format(testcase, len(result)))