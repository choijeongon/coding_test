t = input()

count = 1

dic = {}

for index in range(int(t)):
    data = input()

    result = ''

    temp = ''

    for i in data:
        temp = i + temp
    
    if data == temp:
        result = '1'
    else:
        result = '0'

    dic[index+1] = result

while count <= int(t):
    print('#' + str(count) + " " + str(dic[count]))
    count += 1
