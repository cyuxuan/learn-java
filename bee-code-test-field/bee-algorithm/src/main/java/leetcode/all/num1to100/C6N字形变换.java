/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package leetcode.all.num1to100;

public class C6N字形变换 {
    public static void main(String[] args) {
        C6N字形变换 test = new C6N字形变换();
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        // 计算每组数据量
        int ri = (numRows-1)*2;
        // 定义两个指针
        int t = ri; // 逆序遍历每组数据

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            // 处理每一组数据
            for(int j = i ; j < s.length(); j += ri) {
                // 计算逆序应该在的位置
                int tt = (t%ri) + j - i;
                if(j == tt) {
                    sb.append(s.charAt(j));
                } else if(j > tt) {
                    break;
                } else {
                    sb.append(s.charAt(j));
                    if(tt < s.length()) {
                        sb.append(s.charAt(tt));
                    }
                }
            }
            t--;
        }
        return sb.toString();
    }
}
