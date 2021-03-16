package com.mercury.ds._01_str.easy;

import java.util.ArrayList;
import java.util.List;

public class MatchRule {
    public static void main(String[] args) {
        /**
         * [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
         * "color"
         * "silver"
         */

        List<String> temp = new ArrayList<>();
        temp.add("phone");
        temp.add("blue");
        temp.add("pixel");

        List<String> temp1 = new ArrayList<>();
        temp1.add("computer");
        temp1.add("silver");
        temp1.add("lenovo");

        List<String> temp2 = new ArrayList<>();
        temp2.add("phone");
        temp2.add("gold");
        temp2.add("iphone");

        List list = new ArrayList();
        list.add(temp);
        list.add(temp1);
        list.add(temp2);

        int i = countMatches(list, "color", "silver");
        System.out.println(i);


    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }

        int count = 0;
        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index))) {
                count++;
            }
        }
        return count;
    }

}


/**
 * 1773. 统计匹配检索规则的物品数量  【难度简单】
 *
 * 问题描述：
 *
 *  给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 * <p>
 * 示例 1：
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 * <p>
 * 示例 2：
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 * <p>
 * 提示：
 * 1 <= items.length <= 104
 * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * ruleKey 等于 "type"、"color" 或 "name"
 * 所有字符串仅由小写字母组成
 */
