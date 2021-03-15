package com.mercury.ds._01_str;

public class LastWordLength {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("a "));
    }

    public static int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }

        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    public static int lengthOfLastWord2(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int len = 0;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                len = s.length() - i - 1;
                break;
            }

            if (i == 0) {
                len = s.length();
            }
        }

        return len;
    }
}

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 */
