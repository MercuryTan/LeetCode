package com.mercury.ds._01_str.medium;


import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    /*public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        back(result, n, 0, new StringBuffer());
        return result;
    }

    private void back(List<String> result, int n, int index, StringBuffer stringBuffer) {
        if (index == 2 * n) {
            result.add(stringBuffer.toString());
        } else {
            for (int i = 0; i < 2 * n; i++) {

            }
        }
    }
*/

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        back(result, new StringBuffer(), 0, 0, n);
        return result;
    }


    /**
     *
     * @param result
     * @param buffer
     * @param left 左括号用了多少个
     * @param right 右括号用了多少个
     * @param n 生成括号的对数
     */
    private static void back(List<String> result, StringBuffer buffer, int left, int right, int n) {
        // 如果满足左括号==右括号，并且左括号数量为3，那么就退出当次循环
        if (left == right && left == n) {
            result.add(buffer.toString());
            return;
        }

        // 如果右括号数量大于左括号数量，退出循环
        if (right > left) {
            return;
        }

        // 如果左括号数量小于 n，那么继续加左括号
        if (left < n) {
            buffer.append("(");
            back(result, buffer, left + 1, right, n);
            buffer.deleteCharAt(buffer.length() - 1);
        }

        // 如果右括号下于左括号，那么加右括号
        if (right < left) {
            buffer.append(")");
            back(result, buffer, left, right + 1, n);
            buffer.deleteCharAt(buffer.length() - 1);
        }

    }


}


/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */