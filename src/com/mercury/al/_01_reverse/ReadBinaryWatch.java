package com.mercury.al._01_reverse;


import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(2));
//        System.out.println(readBinaryWatch2(4)); // 解法2
//        System.out.println(readBinaryWatch3(4)); // 解法3
    }

    static int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    static int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};

    static List<String> res = new ArrayList<>();

    /**
     * 解法1：
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);
        return res;
    }
    /**
     * 1、结束条件：hour > 11 || minute >59
     *            num == 0  保存时间
     *
     * 2、选择列表
     *       index之后的灯  由index的值来控制
     *
     * 3、路径
     *      hour[index]  minute[index]
     *
     * @param num    剩余需要点亮的灯数量
     * @param index  从索引index开始往后点亮灯
     * @param hour   当前小时数
     * @param minute 当前分钟数
     */
    public static void backtrack(int num, int index, int hour, int minute) {
        if (hour > 11 || minute > 59) {
            return;
        }
        if (num == 0) { // 0、结束条件
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        // 1、for 选择in 选择列表
        for (int i = index; i < 10; i++) {
            //2、 做选择
            // 2.1 把选择保存到路径中            hour = hour+hours[i]  minute = minute + minutes[i]
            // 2.2 在选择列表中移除当前选择        index = i+1了，相当于选择列表变少

            // 3、回溯  ==》 backtrack方法

            // 4、撤销选择
            // 4.1 在路径中移除本次选择     ==> 这里对应的就是没有添加到最终的结果中
            // 4.2 在选择列表中添加这次选择  ==>index又变为i了，自然选择列表还原了
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }


    /**
     * 解法2：位运算
     *
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch2(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    String m = j < 10 ? "0" : "";
                    String str = i + ":" + m + j;
                    result.add(str);
                }
            }
        }
        return result;
    }

    /**
     * 解法3： 回溯，设置路径数组保存走过的索引值
     *   执行用时：936 ms, 在所有 Java 提交中击败了5.63%的用户
     * @param num
     * @return
     */
    public static List<String> readBinaryWatch3(int num) {
        // 1、结束条件： 已点亮的灯数==总数
        // 2、路径： 当前已选择的灯track[]集合
        // 3、选择列表： light[]集合
        List<String> result = new ArrayList<>();
        int[] light = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        int[] track = new int[light.length];
        back(result, num, 0, track, light);
        return result;
    }

    /**
     *
     * @param num      总数
     * @param lightNum 已点亮灯的个数
     * @param track    路径： 如果下标处为1，说明已经点亮
     * @param light
     */
    private static void back(List<String> result, int num, int lightNum, int[] track, int[] light) {
        if (num == lightNum) {
            // track前4位是小时，后6位是分钟
            int hour = 0;
            for (int i = 0; i < 4; i++) {
                if(track[i] == 1) {
                    hour += light[i];
                }
            }
            int minute = 0;
            for (int i = 4; i < track.length; i++) {
                if(track[i] == 1) {
                    minute += light[i];
                }
            }
            String minuteStr = minute < 10 ? "0" : "";
            String str = hour + ":" + minuteStr + minute;
            if (hour < 12 && minute < 60 && result.indexOf(str) == -1) {
                result.add(str);
            }
            return;
        }
        for (int i = 0; i < light.length; i++) {
            // 设置选择列表，保存路径
            if (track[i] == 1) { // 如果i位置已经走过了，那么说明不能选。相当于重置了选择列表
                continue;
            }
            track[i] = 1;

            // 回溯
            back(result, num, lightNum + 1, track, light);

            // 还原选择列表，撤销选择
            track[i] = 0;

        }
    }


    /**
     *
     * 时：  8 4  2 1
     * 分： 32 16 8 4 2 1
     *
     ** 例如，上面的二进制手表读取 “3:25”。
     * 给定一个非负整数 n代表当前 LED 亮着的数量，返回所有可能的时间。
     *
     * 示例：
     *
     * 输入: n = 1
     * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     *
     * 提示：
     *
     * 输出的顺序没有要求。
     * 小时不会以零开头，比如 “01:00”是不允许的，应为 “1:00”。
     * 分钟必须由两位数组成，可能会以零开头，比如 “10:2”是无效的，应为 “10:02”。
     * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
     */
}
