package com.mercury.ds._01_str;

public class Palindrome {

    public static void main(String[] args) {
        String s = "a.";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }

    /**
     * 执行用时：47 ms, 在所有 Java 提交中击败了5.06%的用户
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        boolean flag = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                flag = false;
            }
        }
        return flag;
    }
}


/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */