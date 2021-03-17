package com.mercury.ds._01_str.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static Map<Character, String> dic = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        back(result, digits, 0, new StringBuffer());

        return result;
    }

    private static void back(List<String> result, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            result.add(stringBuffer.toString());
        } else {
            // 比如abc
            String currStr = dic.get(digits.charAt(index));
            for (char c : currStr.toCharArray()) {
                stringBuffer.append(c);
                back(result, digits, index + 1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }

}



/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *  2:abc
 *  3:def
 *  4:ghi
 *  5:jkl
 *  6:mno
 *  7:pqrs
 *  8:tuv
 *  9:wxyz
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
