class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> smap = new HashMap <>();
        Map<Character, Integer> tmap = new HashMap <>();

        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (smap.containsKey(c)){
                smap.put(c, smap.get(c) + 1);
            }
            else smap.put(c, 1);

            if (tmap.containsKey(d)){
                tmap.put(d, tmap.get(d) + 1);
            }
            else tmap.put(d, 1);
        }

        boolean isMatch = smap.equals(tmap);

    return isMatch;
    }
    
}
// if length of s not equal to t : return false
// create 2 hashmaps - one for s and t
// each letter of string is the key and its frequency is the value
// for loop for adding each letter in hashmap 
// if letter exists value = value + 1
// if letter does not exist value = 1
// after for loop ends
// compare if hashmap s = hashmap t : return false
// else : true