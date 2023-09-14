package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 从键盘输入一个没有重复元素的字符串，输出这个字符串所有字符的全排列
 * 解法：使用全排列进行求解 - 回溯法解题过程中的图解
 * https://leetcode.cn/problems/permutations/solutions/9914/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 *
 * 输入格式:
 * 一个字符串，输入保证字符串中没有重复的字符，字符串的长度不超过10，字符串中不含空格。
 *
 * 输出格式:
 * 按字典序输出该字符串所有字符的全排列。每个字符之间没有空格。每种排列之间换行。
 *
 * 输入样例1:
 * ABC
 * 输出样例1:
 * ABC
 * ACB
 * BAC
 * BCA
 * CAB
 * CBA
 */
public class AllSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ret = permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> ret = new ArrayList<>();

        if (len == 0) {
            return ret;
        }
        boolean[] visted = new boolean[len];
        List<Integer> path = new ArrayList<>();

        allSort(nums, 0, visted, path, ret);
        return ret;
    }

    public static void allSort(int[] nums, int index, boolean[] visted, List<Integer> path, List<List<Integer>> ret) {
        if (index >= nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visted[i]) {
                visted[i] = true;
                path.add(nums[i]);

                allSort(nums, index+1, visted, path, ret);

                visted[i] =false;
                path.remove(path.size()-1);
            }
        }
    }
}

