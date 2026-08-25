class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        s_dict = dict(Counter(s))
        t_dict = dict(Counter(t))

        if s_dict == t_dict :
            return True
    
        return False






