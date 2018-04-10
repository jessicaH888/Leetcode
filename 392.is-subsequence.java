/*
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * algorithms
 * Medium (44.63%)
 * Total Accepted:    50.6K
 * Total Submissions: 113.3K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * 
 * 
 * You may assume that there is only lower case English letters in both s and
 * t. t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (
 * 
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * 
 * 
 * Return true.
 * 
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * 
 * 
 * Return false.
 * 
 * 
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null) {
        	return false;
        }
        if(s.length() == 0 && t.length() == 0) {
        	return true;
        }
        if(t.length() == 0) {
        	return false;
        }
        
        int i = 0, j = 0;
        for(i = 0; i < s.length(); i++) {
        	if(i == s.length() - 1 && j == t.length() - 1
        		&& s.charAt(i) != t.charAt(j)) {
        		return false;
        	}
        	if(s.charAt(i) == t.charAt(j)) {
        		j++;
        		continue;
        	}
        	j++;
        	while(j < t.length()) {
        		if(s.charAt(i) != t.charAt(j)) {
        			j++;
        		}else {
        			j++;
        			break;
        		}
        	}
        	if(j == t.length() && i < s.length() - 1) {
        		return false;
        	}
        }
        return i == s.length();
    }
}
