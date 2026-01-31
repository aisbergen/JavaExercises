public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var lastSeen = new Dictionary<char, int>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.Length; right++) {
            if (lastSeen.ContainsKey(s[right])) {
                left = Math.Max(left, lastSeen[s[right]] + 1);
            }
            
            lastSeen[s[right]] = right;
            maxLength = Math.Max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}