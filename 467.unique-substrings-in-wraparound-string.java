/*
 * [467] Unique Substrings in Wraparound String
 *
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/
 *
 * algorithms
 * Medium (33.23%)
 * Total Accepted:    12.3K
 * Total Submissions: 36.9K
 * Testcase Example:  '"a"'
 *
 * Consider the string s to be the infinite wraparound string of
 * "abcdefghijklmnopqrstuvwxyz", so s will look like this:
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 
 * Now we have another string p. Your job is to find out how many unique
 * non-empty substrings of p are present in s. In particular, your input is the
 * string p and you need to output the number of different non-empty substrings
 * of p in the string s.
 * 
 * Note: p consists of only lowercase English letters and the size of p might
 * be over 10000.
 * 
 * Example 1:
 * 
 * Input: "a"
 * Output: 1
 * 
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string
 * s.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of
 * string "zab" in the string s.
 * 
 * 
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
    	if(p == null || p.length() == 0) {
    		return 0;
    	}
        int n = p.length();
        int[] dp = new int[26];
        int pos = 0;
        for(int i = 0; i < n; i++) {
        	if(i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i) =='a' && p.charAt(i - 1) == 'z'))) {
        		pos++;
        	}else {
        		pos = 1;
        	}
        	dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], pos);
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
        	ans += dp[i];
        }
        return ans;
    }
}
