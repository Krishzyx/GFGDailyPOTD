import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {

        if (k == 0 || s.length() == 0) {
            return -1;
        }

        int left = 0;
        int maxLen = -1;   // Important for GFG

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink window if more than k unique characters
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // Update maxLen only when exactly k unique
            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
