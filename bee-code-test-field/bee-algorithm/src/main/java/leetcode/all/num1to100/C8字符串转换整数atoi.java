/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package leetcode.all.num1to100;

import java.util.LinkedList;
import java.util.Queue;

public class C8字符串转换整数atoi {
    public static void main(String[] args) {
        C8字符串转换整数atoi test = new C8字符串转换整数atoi();
//        test.myAtoi("123");
        System.out.println(test.myAtoi("20000000000000000000"));
    }

    public long myAtoi(String s) {
        s = s.trim();
        // 找到符号后接数字的位置
        if(s.length() == 0) {
            return 0;
        }
        int index = 0;
        Queue<Character> queue = new LinkedList<>();
        if(s.charAt(index) < '0' || s.charAt(index) > '9') {
            if((s.charAt(index) == '-' || s.charAt(index) == '+') && s.length() > 1) {
                if(s.charAt(index + 1) < '0' || s.charAt(index + 1) > '9') {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        while (index < s.length()) {
            // 直接是数字
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                queue.add(s.charAt(index));
            } else if (s.charAt(index) == '-' || s.charAt(index) == '+') {
                if (queue.isEmpty()) {
                    queue.add(s.charAt(index));
                } else {
                    break;
                }
            } else {
                if (!queue.isEmpty()) {
                    break;
                }
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : queue) {
            sb.append(c);
        }
        Long res = null;
        try {
            res = Long.parseLong(sb.toString());
        } catch (Exception e) {
            res = (long) Integer.MAX_VALUE;
            if(sb.toString().charAt(0) == '-') {
                res = (long) Integer.MIN_VALUE;
            }
        }
        if(res > Integer.MAX_VALUE) {
            res = (long) Integer.MAX_VALUE;
        }
        if(res < Integer.MIN_VALUE) {
            res = (long) Integer.MIN_VALUE;
        }
        return res.intValue();
    }
}
