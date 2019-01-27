class Solution:
    def judgeCircle(self, moves):
        
        h=v=0
        for c in moves:
            if c == "U":
                v+=1
            elif c == "L":
                h-=1
            elif c == "D":
                v-=1
            elif c == "R":
                h+=1
        if h==0 and v==0:
            return True
        return False
