
T = int(input())

result_map = {}

for index in range(T):
    N = int(input())

    number_list = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']

    count = 1

    while number_list:
        number = N * count
        # print(number)
        number_string = str(number)

        for value in number_string:
            if value in number_list:
                number_list.remove(value)
        count += 1

    result_map[index+1] = (count-1) * N

for index in range(T):
    print('#' +str(index+1) + ' ' + str(result_map[index+1]))

