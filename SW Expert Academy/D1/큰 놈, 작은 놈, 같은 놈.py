t = input()

count = 1

dic = {}

for index in range(int(t)):
    data = list(map(int, input().split()))
    result = ''

    if data[0] > data[1]:
        result = '>'
    elif data[0] < data[1]:
        result = '<'
    elif data[0] == data[1]:
        result = '='

    dic[index+1] = result


while count <= int(t):
    print('#' + str(count) + " " + str(dic[count]))
    count += 1