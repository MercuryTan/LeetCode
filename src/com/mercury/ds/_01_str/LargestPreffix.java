package com.mercury.ds._01_str;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestPreffix {
    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        List<String> list = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        String templateStr = list.get(0);
        boolean flag = true;
        for (int i = templateStr.length(); i >= 0; i--) {
            String str = templateStr.substring(0, i);

            for (int j = 1; j < list.size(); j++) {
                String sstr = list.get(j).substring(0, i);
                if (!str.equals(sstr)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return str;
            } else {
                flag = true;
            }
        }

        return "";
    }

}

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
