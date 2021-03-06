package com.mercury.ds._01_str.medium;

public class MyAtoi {
    public static void main(String[] args) {
//        System.out.println(myAtoi(""));

        System.out.println(myAtoi2("-2147483647"));
    }

    public static int myAtoi2(String s) {
        int index = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return 0;
        }
        // 跳过空串
        while (index < len && chars[index] == ' ') {
            index++;
        }

        if (index == len) {
            return 0;
        }

        // flag:1 正数   -1:负数
        int flag = 1;
        char firstChar = chars[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            flag = -1;
            index++;
        }

        int result = 0;
        while (index < len) {
            char curr = chars[index];
            // 校验是否为数字，如果不是，那么跳出遍历
            if (curr < '0' || curr > '9') {
                break;
            }

            int currInt = curr - '0';

            // 判断有没有越界
            if ((result > Integer.MAX_VALUE / 10)
                    || (result == Integer.MAX_VALUE / 10 && currInt > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;

            } else if ((result < Integer.MIN_VALUE / 10)
                    || (result == Integer.MIN_VALUE / 10 && currInt > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + flag * (curr - '0');

            index++;
        }

        return result;
    }


    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        StringBuffer result = new StringBuffer();
        char[] chars = s.toCharArray();
        char firstChar = chars[0];
        // 判断第一位的情况，决定之后从哪开始遍历
        if (isSymbol(firstChar) || checkNumber(firstChar)) {
            index = 1;
            result.append(firstChar);
        } else {
            return 0;
        }

        while (index < chars.length) {
            char temp = chars[index];
            // 如果当前不是数字，那么退出遍历
            if (!checkNumber(temp)) {
                break;
            }
            result.append(temp);
            index++;
        }

        // 如果只有一位，并且还是符号位，那么直接返回0
        if (result.length() == 1 && isSymbol(result.charAt(0))) {
            return 0;
        }

        String finalString = transformString(result.toString());
        int resultInt = Integer.parseInt(finalString);
        return resultInt;
    }

    private static String transformString(String result) {
        // 如何判断字符串是否在int区间内  ==> 异常捕获
        String finalString = "";
        try {
            int i = Integer.parseInt(result);
            finalString = result;
        } catch (Exception e) {
            if (result.charAt(0) == '-') {
                finalString = "-2147483648";
            } else {
                finalString = "2147483647";
            }
        }

        return finalString;
    }

    public static boolean checkNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isSymbol(char c) {
        return c == '-' || c == '+';
    }


}


/**
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："42"（读入 "42"）
 * ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 示例2：
 * <p>
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 * ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 * ^
 * 第 3 步："   -42"（读入 "42"）
 * ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 示例3：
 * <p>
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 * ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 * 示例4：
 * <p>
 * 输入：s = "words and 987"
 * 输出：0
 * 解释：
 * 第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * ^
 * 第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
 * ^
 * 解析得到整数 0 ，因为没有读入任何数字。
 * 由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
 * 示例5：
 * <p>
 * 输入：s = "-91283472332"
 * 输出：-2147483648
 * 解释：
 * 第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
 * ^
 * 第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
 * ^
 * 第 3 步："-91283472332"（读入 "91283472332"）
 * ^
 * 解析得到整数 -91283472332 。
 * 由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */