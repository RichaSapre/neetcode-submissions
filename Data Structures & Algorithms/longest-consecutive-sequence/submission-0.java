class Solution {
    public int longestConsecutive(int[] nums) {
        int longConsecSequence = 0;
        Map<Integer, Boolean> travelMap = new HashMap<>();
        for(int num : nums){
            travelMap.put(num, Boolean.FALSE);
        }

        for(int num : nums){
            int currentLength = 1;
            
            int nextNum = num+1;
            while(travelMap.containsKey(nextNum) && travelMap.get(nextNum) == false){
                currentLength++;
                travelMap.put(nextNum, Boolean.TRUE);

                nextNum++;
            }

            int prevNum = num-1;
            while(travelMap.containsKey(prevNum) && !travelMap.get(prevNum)){
                currentLength++;
                travelMap.put(prevNum, Boolean.TRUE);

                prevNum--;
            }
            longConsecSequence = Math.max(longConsecSequence, currentLength);
        }
        return longConsecSequence;
    }
}
