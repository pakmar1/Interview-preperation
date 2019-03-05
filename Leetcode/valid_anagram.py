class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        if len(s) != len(t):
            return False
        s_ = {}
        t_ = {}
        
        for chs in s:
            if chs in s_.keys():
                s_[chs]+=1
            else:
                s_[chs] = 1
        for cht in t:
            if cht in t_.keys():
                t_[cht]+=1
            else:
                t_[cht] = 1    
                
        return s_ == t_
