class Solution { 
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();

        for(int i = 0 ; i<nums.length; i++){
             
            if(twoSumMap.containsKey(target - nums[i])){
                int[] op = {twoSumMap.get(target - nums[i]), i};
                return op;
            }
            else twoSumMap.put(nums[i], i);

        }
        int[] edgecase = {-1};
        return edgecase;
        
    }
}
// create hashmap (key: current element, value: index)
// i will apply for loop on array for each element and check hashmap for an integer we get by subtracting it from target element (target-element)
// (7-3=4, 4 is checked in hash map)
// if the subtracted value is not in hashmap
// add current element to hashmap and move to next
// if subtracted element exists then return index of current and subtracted element
