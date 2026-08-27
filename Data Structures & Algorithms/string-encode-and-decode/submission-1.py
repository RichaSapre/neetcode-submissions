class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + "#" + s 
#str turns the length of s (eg = 2) to a string format as we want entire answer as a string
        return res
        

    def decode(self, s: str) -> List[str]:
        res , i = [],0 
        #i is position of element in sting, 0 for now since theres nothing

        while i < len(s):
            j = i
            while s[j] != "#":
                j += 1
            length = int(s[i:j])
            res.append(s[j+1 : j+1+length])
            i= j + 1 + length
        return res

        
