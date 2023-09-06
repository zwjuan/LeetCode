package od.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 438. 找到字符串中所有字母异位词 - 滑动窗口
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 解法1：- 维护和p相同大小的滑动窗口1
 * 在字符串 sss 中构造一个长度为与字符串 ppp 的长度相同的滑动窗口，
 * 并在滑动中维护窗口中每种字母的数量；当窗口中每种字母的数量与字符串 ppp 中每种字母的数量相同时，则说明当前窗口为字符串 ppp 的异位词。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */

public class LeetCode_438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));

        System.out.println(findAnagrams("abab", "ab"));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null) {
            return list;
        }

        int slen = s.length(), plen = p.length();
        if (slen < plen) {
            return list;
        }

        int[] sarr = new int[26];
        int[] parr = new int[26];

        for (int i=0; i<plen; i++) {
            ++sarr[s.charAt(i) - 'a'];
            ++parr[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sarr, parr)) {
            list.add(0);
        }

        for (int i=0; i<slen-plen; i++) {
            --sarr[s.charAt(i) - 'a'];
            ++sarr[s.charAt(i + plen) -'a'];

            if (Arrays.equals(sarr, parr)) {
                list.add(i+1);
            }
        }
        return list;
    }

}
