class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
      myhashset = set()
      for i in nums:
       if i in myhashset:
        return True
       else:
        myhashset.add(i)
      
      return False

#         create hashset
# for (i to length of array){
#     if exists in set{
#         return true
#     }
#     else add to set
# }

# return false