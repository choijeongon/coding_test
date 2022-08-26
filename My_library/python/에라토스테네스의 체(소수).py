
def prime_list(n):
    #n개 요소에 True로 설정(소수로 간주)
    sieve = [True] * n

    # n의 최대 약수가 sqrt(n) 이하이므로 i = sqrt(n)까지 검사
    m = int(n ** 0.5)
    for i in range(2, m+1):
        if sieve[i] == True: #i가 소수라면
            for j in range(i+i, n, i): #i이후 i의 배수들을 False 판정
                sieve[j] = False
    
    return [i for i in range(2, n) if sieve[i] == True]