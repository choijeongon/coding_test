
N = int(input())

result = ''

for index in range(1, N+1):
    if '3' in str(index) or '6' in str(index) or '9' in str(index):
        value = str(index)
        count = 0
        add = ''

        for ch in value:
            if '3' in ch or '6' in ch or '9' in ch:
                count += 1
        
        if count == 1:
            add += '-'
        elif count == 2:
            add += '--'
        elif count == 3:
            add += '---'
        
        result += add
        result += ' '
        continue

    result += str(index)
    result += ' '

print(result)
