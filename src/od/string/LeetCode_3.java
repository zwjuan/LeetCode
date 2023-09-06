package od.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串 - 滑动窗口
 * 解法1：借助hashmap 注：先求出left值然后做判断
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LeetCode_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

        //特殊case
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <=0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left  = Math.max(left, map.get(s.charAt(i)) + 1);  //先求left值
            }
            maxLen = Math.max(maxLen, i - left + 1); //即使hashmap不存在也更新maxlen值
            map.put(s.charAt(i), i);
        }
        return maxLen;
    }
}
