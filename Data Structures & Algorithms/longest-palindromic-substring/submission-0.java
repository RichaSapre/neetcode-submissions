class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        String LPS = "";

        for (int i = 0; i < s.length(); i++) {

            // odd length
            int low = i;
            int high = i;

            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                String palindrome = s.substring(low, high + 1);

                if (palindrome.length() > LPS.length()) {
                    LPS = palindrome;
                }

                low--;
                high++;
            }

            // even length
            low = i;
            high = i + 1;

            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                String palindrome = s.substring(low, high + 1);

                if (palindrome.length() > LPS.length()) {
                    LPS = palindrome;
                }

                low--;
                high++;
            }
        }

        return LPS;
    }
}