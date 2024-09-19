/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package leetcode.all.num1to100;

public class C9回文数 {
    public static void main(String[] args) {
        C9回文数 a = new C9回文数();
        System.out.println(a.isPalindrome(1221));
    }

    public boolean isPalindrome(int x) {
        // 转换成字符串
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length();
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
