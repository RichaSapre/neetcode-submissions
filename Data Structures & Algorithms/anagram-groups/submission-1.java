class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i : count){
                sb.append("#");
                sb.append(i);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
        
    }
}
 
// create frequency bucket of 26 [0-25] and each letter freq number increases and then hash it
// add hashed frequencies of first string
// if the hashed freq string doesnt exist add it to hashmap
// if it exists add string to the values of the freq string
// return the values as a set