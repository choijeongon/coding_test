
T = int(input())

for i in range(1, T+1):
    N = int(input())

    omanwon_count = 0
    manwon_count = 0
    ochunwon_count = 0
    chunwon_count = 0
    obackwon_count = 0
    backwon_count = 0
    oshipwon_count = 0
    shipwon_count = 0

    if N < 50000:
        omanwon_count = 0
    else:
        omanwon_count = N // 50000
        N %= 50000
    
    if N < 10000:
        manwon_count = 0
    else:
        manwon_count = N // 10000
        N %= 10000
        
    if N < 5000:
                ochunwon_count = 0
    else:
        ochunwon_count = N // 5000
        N %= 5000

    if N < 1000:
        chunwon_count = 0
    else:
        chunwon_count = N // 1000
        N %= 1000

    if N < 500:
        obackwon_count = 0
    else:
        obackwon_count = N // 500
        N %= 500

    if N < 100:
        backwon_count = 0
    else:
        backwon_count = N //100
        N %= 100

    if N < 50:
        oshipwon_count = 0
    else:
        oshipwon_count = N // 50
        N %= 50

    if N < 10:
        shipwon_count = 0
    else:
        shipwon_count = N // 10
        N %= 10
    print("#" + str(i))
    print('{} {} {} {} {} {} {} {}'.format(omanwon_count, manwon_count, ochunwon_count, chunwon_count, obackwon_count, backwon_count, oshipwon_count, shipwon_count))

    
