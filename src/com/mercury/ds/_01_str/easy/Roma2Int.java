package com.mercury.ds._01_str.easy;

public class Roma2Int {

    public static void main(String[] args) {
        /**
         * 1、左大右小 或 左右相等  两数相加
         * 2、左小右大 并且符合以下规则，两数相减
         */
        int toInt = romanToInt("MCMXCIV");
        System.out.println(toInt);
    }

    /**
     * 输入: "MCMXCIV"
     * * 输出: 1994
     * * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int totalNum = 0;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int num1 = getInt(c);

            if(i == s.length() - 1) {
                totalNum += num1;
                i++;
                break;
            }

            char nextC = s.charAt(i + 1);
            boolean fillFlag = isFill(c, nextC);
            if (fillFlag) {
                int num2 = getInt(nextC);
                totalNum += (num2 - num1);
                i = i + 2;
                // 如果是最后一位或者左大右小
            } else {
                totalNum += num1;
                i++;
            }

        }
        return totalNum;
    }

    public static boolean isFill(char bChar, char nChar) {
        if (bChar == 'I' && (nChar == 'V' || nChar == 'X')) {
            return true;
        }
        if (bChar == 'X' && (nChar == 'L' || nChar == 'C')) {
            return true;
        }
        if (bChar == 'C' && (nChar == 'D' || nChar == 'M')) {
            return true;
        }
        return false;
    }

    public static int getInt(char c) {
        int num = 0;
        switch (c) {
            case 'I':
                num = 1;
                break;
            case 'V':
                num = 5;
                break;
            case 'X':
                num = 10;
                break;
            case 'L':
                num = 50;
                break;
            case 'C':
                num = 100;
                break;
            case 'D':
                num = 500;
                break;
            case 'M':
                num = 1000;
                break;
        }
        return num;
    }
}


/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 */
