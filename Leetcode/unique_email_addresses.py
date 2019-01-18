class Solution:
    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        uni = []
        anss = False
        for i in range(len(emails)):
            
            email = emails[i]
            domain = ""
            
            x = 0
            while(x<len(email)):
                if email[x] == '@':
                    domain = email[x:]
                    break
                else:
                    x += 1

            em = ""
            j=0
            while(j <len(email)):
                if email[j] == '.':
                    j+=1
                elif email[j] == '+':
                    break
                else:
                    em+=email[j]
                    j+=1
            comb = em+domain
 
            
            for y in range(len(uni)):
                if uni[y] == comb:
                    anss = True
                    break
                else:
                    anss = False
                    

            if anss == False:
                uni.append(em+domain)
        return len(uni)
         
    def emailExists(self,comb,uni):
        for i in range(len(uni)):
            if uni[i] == comb:
                return True
        return False
        
