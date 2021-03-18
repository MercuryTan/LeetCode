package com.mercury.al._01_reverse;


import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(3));
    }

    static int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    static int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};

    static List<String> res = new ArrayList<>();

    public static List<java.lang.String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);

//        back(num, 0, new ArrayList<Integer>());

        return res;
    }

/*    private static void back(int num, int index, List<Integer> track) {
        if (num == 0) {
            return;
        }

        // 当前路径为：
        track.add(arr[index]);

        // 可以选择的列表为：
        for (int i = index + 1; i < arr.length; i++) {

        }

    }*/


    /**
     * 1、结束条件  hour>11 || minute >59  ||num==0  ==>保存路径
     * 2、路径
     * 3、可选择列表
     *   比如i=0,可选择的就是>0的  选择num个
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
        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        // 最多有10个灯
        for (int i = index; i < 10; i++) {
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
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
