package com.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 用栈的数据结构解决计算问题
 */
public class PolandNotation {
    public static void main(String[] args) {
        String sss = "100+((2+3)*4)-5";
        List<String> list = new ArrayList<>();
        String str = "";
        boolean flag = false;
        for (int i = 0; i < sss.length(); i++) {
            if (sss.charAt(i) < 48 || sss.charAt(i) > 57) { //代表是个字符
                list.add(sss.charAt(i) + "");
                flag = false;
            } else { //代表是个数字
                if (i == 0) {
                    flag = true;
                    list.add(sss.charAt(i) + "");
                } else {
                    if (flag) {
                        str = "";
                        str = list.get(list.size() - 1) + sss.charAt(i);
                        list.remove(list.size() - 1);
                        list.add(str);
                    } else {
                        list.add(sss.charAt(i) + "");
                    }
                }

            }

        }
        System.out.println(list);
    }


}
