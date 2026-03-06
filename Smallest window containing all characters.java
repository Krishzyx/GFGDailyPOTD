import java.util.*;

class Solution {
    public static String minWindow(String s, String p) {

        HashMap<Character, Integer> map = new HashMap<>();

        // store frequency of pattern
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size();   // number of unique chars needed
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (right < s.length()) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    count--;
                }
            }

            // try shrinking window
            while (count == 0) {

                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++;
            }

            right++;
        }

        if (startIndex == -1) return "";

        return s.substring(startIndex, startIndex + minLen);
    }
}
