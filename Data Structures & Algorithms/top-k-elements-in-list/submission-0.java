class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1 );
        }

        for(int key : map.keySet()){
            int frequency = map.get(key);
            if (bucket[frequency] == null){
              bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] res = new int[k];
        int counter = 0;

        for(int x = bucket.length-1; x>=0 && counter < k; x--){
            if(bucket[x] != null){
                for(Integer integer : bucket[x]){
                    res[counter++] = integer;
                }
            }
        }
        return res;
    }
}
