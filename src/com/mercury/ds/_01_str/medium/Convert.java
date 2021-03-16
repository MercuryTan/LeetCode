package com.mercury.ds._01_str.medium;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    /**
     * 思路： 定义标识符，判断方向
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int index = 0;
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }

        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            list.get(index).append(chars[i]);
            // 如果到底 就需要改变方向
            if (i % (numRows - 1) == 0) {
                flag = !flag;
            }

            // 向下
            if (flag) {
                index++;
            } else {
                index--;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StringBuffer temp : list) {
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}


/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 0 6 12   1 5 7 11 13   2 4 8 10   3 9
 *
 *
 *      * P   A   H   N
 *      * A P L S I I G
 *      * Y   I   R
 *
 *      0  2 4 6 8 10 12
 *
 *      Row:3
 *      0 4 8 12     1 3 5 7 9 11 13      2 4 6
 *
 *      Row:4
 *      0 6 12       1 5 7 11 13          2 4 8 10         3 9
 *
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
