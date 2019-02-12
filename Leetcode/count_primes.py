class Solution:
    def countPrimes(self, n: 'int') -> 'int':
        count = 0
        if n<2:
            return 0
        primes=[True]*n
        primes[0] = primes[1] = False
        
        for i in range(2,n):
            if primes[i] == True:
                for j in range(2,n):
                    if i*j<n:
                        primes[i*j]=False
                    else:
                        break
        
        for k in range(2,len(primes)):
            if primes[k]==True:
                count+=1
        return count
