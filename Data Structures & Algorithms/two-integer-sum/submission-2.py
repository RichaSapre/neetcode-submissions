class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 2 :
            return [0,1]
        
        map = {}
        
        for i,n in enumerate(nums) :
            diff = target - n
            if diff in map : 
                return [map[diff], i]
            map[n] = i
        return