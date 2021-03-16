package com.mercury.ds._01_str;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if(!isVowel(chars[left])) {
                left++;
                continue;
            }
            if(!isVowel(chars[right])) {
                right--;
                continue;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;

        }
        return String.valueOf(chars);
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }


}


/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 */