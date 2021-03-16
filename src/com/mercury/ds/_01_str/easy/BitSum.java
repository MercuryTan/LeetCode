package com.mercury.ds._01_str.easy;

public class BitSum {
    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String s = addBinary2(a, b);
        System.out.println(s);

    }

    public static String addBinary(String a, String b) {
        int i = Integer.parseInt(a, 2);
        int j = Integer.parseInt(b, 2);
        int i1 = i + j;
        return Integer.toBinaryString(i1) + "";
    }

    /**
     * 思路：
     * 1、从右往左遍历字符串
     * 2、定义进位数： carry： 如果为1；说明要进位   为0：说明不用进位
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
        StringBuffer result = new StringBuffer();
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;
        // 1、从右往左遍历
        while (lenA >= 0 || lenB >= 0) {
            // sum起始值为0，后续可能会变为1（两数进位的结果）
            int sum = carry;
            if (lenA >= 0) {
                sum += (a.charAt(lenA) - '0'); // -'0' 是为了让字符串变为int
                lenA--;
            }

            if (lenB >= 0) {
                sum += (b.charAt(lenB) - '0');
                lenB--;
            }

            // 如果sum为0或1 那么当前该位保存的值就是0或1 。如果sum为2（二进制位10），那么当前该位保存的值就为0，二进制中的1就是进位
            result.append(sum % 2);
            // 更改进位  carry： 如果为1；说明要进位   为0：说明不用进位
            carry = sum / 2;
        }

        // 如果计算到最后，还有进位。那么需要额外补1
        if(carry != 0) {
            result.append("1");
        }

        // 反转字符串并输出
        return result.reverse().toString();
    }

}

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字1和0。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
