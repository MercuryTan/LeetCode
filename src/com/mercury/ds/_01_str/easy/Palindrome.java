package com.mercury.ds._01_str.easy;

public class Palindrome {

    public static void main(String[] args) {
        String s = "race a car";
        boolean palindrome = isPalindrome2(s);
        System.out.println(palindrome);
    }

    /**
     * 执行用时：47 ms, 在所有 Java 提交中击败了5.06%的用户
     *
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

    /**
     * 【执行用时：4 ms, 在所有 Java 提交中击败了64.48%的用户】
     *
     *  思路：
     *  1、先把字符串的值都置位小写
     *  2、定义两个指针，从头尾遍历。如果碰到不是a-z,0-9的字符。那么就跳过
     *  3、否则判断是否相等，如果不相等，就直接退出循环
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;
        boolean flag = true;
        while (left < right) {
            if (!isRule(chars[left])) {
                left++;
                continue;
            }
            if (!isRule(chars[right])) {
                right--;
                continue;
            }

            if(chars[left] != chars[right]) {
                flag = false;
                break;
            } else {
                left++;
                right--;
            }
        }

        return flag;
    }

    public static boolean isRule(char c) {
        return (c >= 'a' && c <= 'z') ||  (c >= '0' && c <= '9');
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